package com.example.demo.models.dtos;

import com.example.demo.models.entities.Gpu;

public class GpuDTO {
    private Integer id;
    private String name;
    private String description;
    private int frequency;

    public String getDescription() {
        return description;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public GpuDTO(Integer id, String name, String description, int frequency){
        this.id = id;
        this.name = name;
        this.description = description;
        this.frequency = frequency;
    }

    public static GpuDTO fromEntity(Gpu gpu){
        return new GpuDTO(
                gpu.getId(),
                gpu.getName(),
                gpu.getDescription(),
                gpu.getFrequency()
        );
    }
}
