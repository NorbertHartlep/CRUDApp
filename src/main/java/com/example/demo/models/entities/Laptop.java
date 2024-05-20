package com.example.demo.models.entities;

import com.example.demo.models.dtos.ComputerDTO;
import com.example.demo.models.dtos.LaptopDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Laptop {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDate timestamp;
    private String gpu;
    private String cpu;

    public Laptop() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCpu() {
        return cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public Laptop(Integer id, String name, String description, String gpu, String cpu) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = LocalDate.now();
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public static Laptop fromDto(LaptopDTO laptopDTO){
        return new Laptop(
                laptopDTO.getId(),
                laptopDTO.getName(),
                laptopDTO.getDescription(),
                laptopDTO.getGpu(),
                laptopDTO.getCpu()
        );
    }
}
