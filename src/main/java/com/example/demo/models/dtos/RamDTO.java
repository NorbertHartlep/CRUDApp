package com.example.demo.models.dtos;

import com.example.demo.models.entities.Ram;

public class RamDTO {
    private Integer id;
    private String name;
    private double price;
    private int frequency;
    private String description;

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public RamDTO(Integer id, String name, double price, int frequency, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.frequency = frequency;
        this.description = description;
    }

    public static RamDTO fromEntity(Ram ram){
        return new RamDTO(
                ram.getId(),
                ram.getName(),
                ram.getPrice(),
                ram.getFrequency(),
                ram.getDescription()
        );
    }
}
