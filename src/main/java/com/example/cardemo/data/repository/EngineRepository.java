package com.example.cardemo.data.repository;

import com.example.cardemo.data.entity.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Long> {

    @Override
    void deleteById(Long id);
}