package com.example.demo.models.entities;

import com.example.demo.models.dtos.MotherboardDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Motherboard {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private List<String> availablePorts;
    private LocalDate timestamp;

    public Motherboard() {
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public List<String> getAvailablePorts() {
        return availablePorts;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Motherboard(Integer id, String name, String description, List<String> availablePorts) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availablePorts = availablePorts;
        this.timestamp = LocalDate.now();
    }

    public static Motherboard fromDto (MotherboardDTO motherboardDTO){
        return new Motherboard(
                motherboardDTO.getId(),
                motherboardDTO.getName(),
                motherboardDTO.getDescription(),
                motherboardDTO.getAvailablePorts()
        );
    }
}
