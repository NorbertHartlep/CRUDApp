package com.example.demo.controllers;

import com.example.demo.models.dtos.ComputerDTO;
import com.example.demo.services.ComputerShopService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    private final ComputerShopService service;

    public ComputerController(ComputerShopService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ComputerDTO> save(@RequestBody ComputerDTO computerDTO){
        return ResponseEntity.ok(service.save(computerDTO));
    }

    @GetMapping
    public ResponseEntity<List<ComputerDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<ComputerDTO> edit(@RequestBody ComputerDTO computerDTO){
        return ResponseEntity.ok(service.edit(computerDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
