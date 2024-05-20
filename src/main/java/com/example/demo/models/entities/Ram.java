package com.example.demo.models.entities;

import com.example.demo.models.dtos.RamDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ram {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private double price;
    private int frequency;
    private String description;

    public Ram() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getDescription() {
        return description;
    }

    public Ram(Integer id, String name, double price, int frequency, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.frequency = frequency;
        this.description = description;
    }

    public static Ram fromDTO(RamDTO ramDTO){
        return new Ram(
                ramDTO.getId(),
                ramDTO.getName(),
                ramDTO.getPrice(),
                ramDTO.getFrequency(),
                ramDTO.getDescription()
        );
    }
}
