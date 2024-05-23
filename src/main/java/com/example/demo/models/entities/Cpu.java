package com.example.demo.models.entities;

import com.example.demo.models.dtos.CpuDTO;
import com.example.demo.models.dtos.GpuDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Cpu {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int cores;
    private boolean haveIntegratedGPU;
    private double price;
    private LocalDate timestamp;

    public Cpu() {
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public int getCores() { return cores; }

    public boolean getHaveIntegratedGPU() { return haveIntegratedGPU; }

    public double getPrice() { return price; }

    public Cpu(Integer id, String name, int cores, boolean haveIntegratedGPU, double price){
        this.id = id;
        this.name = name;
        this.cores = cores;
        this.haveIntegratedGPU = haveIntegratedGPU;
        this.price = price;
        this.timestamp = LocalDate.now();
    }

    public  static Cpu fromDto(CpuDTO cpuDTO){
        return new Cpu(
                cpuDTO.getId(),
                cpuDTO.getName(),
                cpuDTO.getCores(),
                cpuDTO.isHaveIntegratedGPU(),
                cpuDTO.getPrice()
        );
    }
}
