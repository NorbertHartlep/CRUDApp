package com.example.demo.models.dtos;

import com.example.demo.models.entities.Cpu;

public class CpuDTO{
    private Integer id;
    private String name;
    private int cores;
    private boolean haveIntegratedGPU;
    private double price;



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCores() {
        return cores;
    }

    public boolean isHaveIntegratedGPU() {
        return haveIntegratedGPU;
    }

    public double getPrice() {
        return price;
    }

    public CpuDTO(Integer id, String name, boolean haveIntegratedGPU, int cores, double price) {
        this.id = id;
        this.name = name;
        this.haveIntegratedGPU = haveIntegratedGPU;
        this.cores = cores;
        this.price = price;
    }

    public static CpuDTO fromEntity(Cpu cpu){
        return new CpuDTO(
                cpu.getId(),
                cpu.getName(),
                cpu.getHaveIntegratedGPU(),
                cpu.getCores(),
                cpu.getPrice()
        );
    }
}
