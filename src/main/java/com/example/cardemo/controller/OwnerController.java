package com.example.cardemo.controller;

import com.example.cardemo.data.entity.Owner;
import com.example.cardemo.dto.OwnerDto;
import com.example.cardemo.service.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/add")
    public ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto newOwner) {
        Owner owner = modelMapper.map(newOwner, Owner.class);
        Owner createdOwner = ownerService.saveOwner(owner);

        OwnerDto mappedDto = modelMapper.map(createdOwner, OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> findOwnerById(@PathVariable(value = "id") Long id) {
        Owner owner = ownerService.findById(id);

        OwnerDto mappedDto = modelMapper.map(owner, OwnerDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Owner> getAllOwners(Pageable pageable) {
        return ownerService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OwnerDto> deleteOwnerById(@PathVariable(value = "id") Long id) {
        Owner owner = ownerService.findById(id);
        OwnerDto mappedDto = modelMapper.map(owner, OwnerDto.class);

        ownerService.deleteOwnerById(id);
        return ResponseEntity.ok(mappedDto);
    }
}