package com.example.demo.models.dtos;

import com.example.demo.models.entities.Laptop;

public class LaptopDTO {
    private Integer id;
    private String name;
    private String description;
    private String cpu;
    private String gpu;

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

    public LaptopDTO(Integer id, String name, String description, String gpu,String cpu) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cpu = cpu;
        this.gpu = gpu;
    }

    public static LaptopDTO fromEntity(Laptop laptop) {
        return new LaptopDTO(
                laptop.getId(),
                laptop.getName(),
                laptop.getDescription(),
                laptop.getGpu(),
                laptop.getGpu()
        );
    }
}