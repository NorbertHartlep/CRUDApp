package com.example.demo.controllers;

import com.example.demo.models.dtos.LaptopDTO;
import com.example.demo.services.LaptopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class LaptopController {
    private final LaptopService service;

    public LaptopController(LaptopService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<LaptopDTO> save(@RequestBody LaptopDTO laptopDTO){
        return ResponseEntity.ok(service.save(laptopDTO));
    }

    @GetMapping
    public ResponseEntity<List<LaptopDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<LaptopDTO> edit(@RequestBody LaptopDTO laptopDTO){
        return ResponseEntity.ok(service.edit(laptopDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
