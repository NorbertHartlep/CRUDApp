package com.example.demo.models.entities;

import com.example.demo.models.dtos.ComputerDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Computer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDate timestamp;
    private String gpu;
    private String cpu;

    public Computer() {
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

    public Computer(Integer id, String name, String description, String gpu, String cpu) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.timestamp = LocalDate.now();
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public static Computer fromDto(ComputerDTO computerDTO){
        return new Computer(
                computerDTO.getId(),
                computerDTO.getName(),
                computerDTO.getDescription(),
                computerDTO.getGpu(),
                computerDTO.getCpu()
        );
    }
}
