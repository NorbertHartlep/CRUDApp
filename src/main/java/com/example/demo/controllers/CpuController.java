package com.example.demo.controllers;

import com.example.demo.models.dtos.ComputerDTO;
import com.example.demo.models.dtos.CpuDTO;
import com.example.demo.services.ComputerService;
import com.example.demo.services.CpuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cpus")
public class CpuController {
    private final CpuService service;

    public CpuController(CpuService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CpuDTO> save(@RequestBody CpuDTO cpuDTO){
        return ResponseEntity.ok(service.save(cpuDTO));
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
    public ResponseEntity<CpuDTO> edit(@RequestBody CpuDTO cpuDTO){
        return ResponseEntity.ok(service.edit(cpuDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}