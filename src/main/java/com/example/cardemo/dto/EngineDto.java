package com.example.cardemo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EngineDto {

    @NotEmpty(message = "Engine number cannot be empty!")
    private String engineNumber;

    @Min(value = 2, message = "Engine capacity must be greater than 1CC!")
    private double engineCapacity;

    @Min(value = 2, message = "Engine power must be greater than 1HP!")
    private int horsePower;

    public EngineDto() {
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}