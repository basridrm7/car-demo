package com.example.cardemo.controller;

import com.example.cardemo.data.entity.Car;
import com.example.cardemo.dto.CarDto;
import com.example.cardemo.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    private ModelMapper modelMapper = new ModelMapper();

    @PostMapping("/add")
    public ResponseEntity<CarDto> createCar(@Valid @RequestBody CarDto newCar) {
        Car car = modelMapper.map(newCar, Car.class);
        Car createdCar = carService.saveCar(car);

        CarDto mappedDto = modelMapper.map(createdCar, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> findCarById(@PathVariable(value = "id") Long id) {
        Car car = carService.findById(id);

        CarDto mappedDto = modelMapper.map(car, CarDto.class);
        return ResponseEntity.ok(mappedDto);
    }

    @GetMapping
    public Page<Car> getAllCars(Pageable pageable) {
        return carService.findAll(pageable);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarDto> deleteCarById(@PathVariable(value = "id") Long id) {
        Car car = carService.findById(id);
        CarDto mappedDto = modelMapper.map(car, CarDto.class);

        carService.deleteCarById(id);
        return ResponseEntity.ok(mappedDto);
    }
}