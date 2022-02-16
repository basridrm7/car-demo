package com.example.cardemo.controller;

import com.example.cardemo.data.entity.Engine;
import com.example.cardemo.dto.EngineDto;
import com.example.cardemo.service.EngineService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/engines")
public class EngineController {

    @Autowired
    private EngineService engineService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/add")
    public ResponseEntity<EngineDto> createEngine(@Valid @RequestBody EngineDto newEngine) {
        Engine engine = modelMapper.map(newEngine, Engine.class);
        Engine createdEngine = engineService.saveEngine(engine);

        EngineDto mappedDto = modelMapper.map(createdEngine, EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EngineDto> findEngineById(@PathVariable(value = "id") Long id) {
        Engine engine = engineService.findById(id);

        EngineDto mappedDto = modelMapper.map(engine, EngineDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Engine> getAllEngines(Pageable pageable) {
        return engineService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EngineDto> deleteEngineById(@PathVariable(value = "id") Long id) {
        Engine engine = engineService.findById(id);
        EngineDto mappedDto = modelMapper.map(engine, EngineDto.class);

        engineService.deleteEngineById(id);
        return ResponseEntity.ok(mappedDto);
    }
}