package com.example.demo.models.dtos;

import com.example.demo.models.entities.Motherboard;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class MotherboardDTO {

    private Integer id;
    private String name;
    private String description;
    private List<String> availablePorts;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getAvailablePorts() {
        return availablePorts;
    }

    public MotherboardDTO(Integer id, String name, String description, List<String> availablePorts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availablePorts = availablePorts;
    }

    public static MotherboardDTO fromEntity(Motherboard motherboard){
        return new MotherboardDTO(
                motherboard.getId(),
                motherboard.getName(),
                motherboard.getDescription(),
                motherboard.getAvailablePorts()
        );
    }
}
