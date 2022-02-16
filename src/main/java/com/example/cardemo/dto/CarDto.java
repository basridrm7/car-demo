package com.example.cardemo.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarDto {

    @Size(min = 2, message = "Not a valid car brand!")
    @NotEmpty(message = "Please provide a car brand!")
    private String brand;

    @Size(min = 2, message = "Not a valid car model!")
    @NotEmpty(message = "Please provide a car model!")
    private String model;

    @NotNull(message = "Please provide the year of manufacture!")
    @Min(value = 1900, message = "Please select a year later than 1899!")
    @Max(value = 2022, message = "Please select a year earlier than 2022!")
    private Integer year;

    @NotEmpty(message = "Please provide the plate number of the car!")
    private String plateNumber;

    @Valid
    @NotNull(message = "Please provide the engine details of the car!")
    private EngineDto engine;

    @Valid
    private OwnerDto owner;

    public CarDto() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public EngineDto getEngine() {
        return engine;
    }

    public void setEngine(EngineDto engine) {
        this.engine = engine;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }
}