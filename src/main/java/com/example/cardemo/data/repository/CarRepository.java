package com.example.cardemo.data.repository;

import com.example.cardemo.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Override
    void deleteById(Long id);
}