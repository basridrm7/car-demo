package com.example.cardemo.data.entity;

import com.example.cardemo.data.entity.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "engine")
public class Engine extends BaseEntity {

    @Column(name = "engine_number", unique = true)
    private String engineNumber;

    @Column(name = "engine_capacity")
    private double engineCapacity;

    @Column(name = "horse_power")
    private int horsePower;

    public Engine() {
    }

    public String getEngineNumber() {
        return this.engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
}