package com.example.demo.controllers;

import com.example.demo.models.dtos.GpuDTO;
import com.example.demo.services.GpuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class GpuController {
    private final GpuService service;

    public GpuController(GpuService service){this.service =service;}

    @PostMapping
    public ResponseEntity<GpuDTO> save(@RequestBody GpuDTO gpuDTO){
        return ResponseEntity.ok(service.save(gpuDTO));
    }

    @GetMapping
    public ResponseEntity<List<GpuDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GpuDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<GpuDTO> edit(@RequestBody GpuDTO gpuDTO){
        return ResponseEntity.ok(service.edit(gpuDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
