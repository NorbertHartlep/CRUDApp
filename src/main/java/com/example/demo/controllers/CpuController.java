package com.example.demo.controllers;

import com.example.demo.models.dtos.CpuDTO;
import com.example.demo.services.CpuServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CpuController {
    private final CpuServices service;

    public CpuController(CpuServices service){this.service =service;}

    @PostMapping
    public ResponseEntity<CpuDTO> save(@RequestBody CpuDTO computerDTO){
        return ResponseEntity.ok(service.save(computerDTO));
    }

    @GetMapping
    public ResponseEntity<List<CpuDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CpuDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<CpuDTO> edit(@RequestBody CpuDTO computerDTO){
        return ResponseEntity.ok(service.edit(computerDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
