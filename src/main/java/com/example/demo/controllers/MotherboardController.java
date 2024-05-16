package com.example.demo.controllers;

import com.example.demo.models.dtos.MotherboardDTO;
import com.example.demo.services.MotherboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MotherboardController {
    private final MotherboardService service;

    public MotherboardController(MotherboardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MotherboardDTO> save(@RequestBody MotherboardDTO motherboardDTO){
        return ResponseEntity.ok(service.save(motherboardDTO));
    }

    @GetMapping
    public ResponseEntity<List<MotherboardDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotherboardDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<MotherboardDTO> edit(@RequestBody MotherboardDTO motherboardDTO){
        return ResponseEntity.ok(service.edit(motherboardDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
