package com.example.cardemo.service;

import com.example.cardemo.data.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    Car saveCar(Car car);

    Car findById(Long id);

    Page<Car> findAll(Pageable pageable);

    void deleteCarById(Long id);
}