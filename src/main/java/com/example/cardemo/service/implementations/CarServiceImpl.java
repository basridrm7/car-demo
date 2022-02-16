package com.example.cardemo.service.implementations;

import com.example.cardemo.data.entity.Car;
import com.example.cardemo.data.repository.CarRepository;
import com.example.cardemo.exception.NotFoundException;
import com.example.cardemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find car with id: " + id));
    }

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }
}