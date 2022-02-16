package com.example.cardemo.service;

import com.example.cardemo.data.entity.Engine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EngineService {

    Engine saveEngine(Engine engine);

    Engine findById(Long id);

    Page<Engine> findAll(Pageable pageable);

    void deleteEngineById(Long id);
}