package com.example.cardemo.service.implementations;

import com.example.cardemo.data.entity.Engine;
import com.example.cardemo.data.repository.EngineRepository;
import com.example.cardemo.exception.NotFoundException;
import com.example.cardemo.service.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EngineServiceImpl implements EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public Engine saveEngine(Engine engine) {
        return engineRepository.save(engine);
    }

    @Override
    public Engine findById(Long id) {
        return engineRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find engine with id: " + id));
    }

    @Override
    public Page<Engine> findAll(Pageable pageable) {
        return engineRepository.findAll(pageable);
    }

    @Override
    public void deleteEngineById(Long id) {
        engineRepository.deleteById(id);
    }
}