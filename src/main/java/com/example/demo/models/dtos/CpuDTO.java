package com.example.demo.models.dtos;

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

}
