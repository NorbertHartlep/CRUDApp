package com.example.demo.models.entities;

import com.example.demo.models.dtos.GpuDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Gpu {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private int frequency;
    private LocalDate timestamp;

    public int getFrequency() {
        return frequency;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return  name;
    }

    public Integer getId() {
        return id;
    }

    public Gpu(Integer id, String name, String description, int frequency){
        this.id = id;
        this.name = name;
        this.frequency = frequency;
        this.description = description;
    }

    public  static Gpu fromDto(GpuDTO gpuDTO){
        return new Gpu(
                gpuDTO.getId(),
                gpuDTO.getName(),
                gpuDTO.getDescription(),
                gpuDTO.getFrequency()
        );
    }
}
