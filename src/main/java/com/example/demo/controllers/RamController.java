package com.example.demo.controllers;

import com.example.demo.models.dtos.RamDTO;
import com.example.demo.services.RamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rams")
public class RamController {
    private final RamService service;

    public RamController(RamService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RamDTO> save(@RequestBody RamDTO ramDTO){
        return ResponseEntity.ok(service.save(ramDTO));
    }

    @GetMapping
    public ResponseEntity<List<RamDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RamDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<RamDTO> edit(@RequestBody RamDTO ramDTO){
        return ResponseEntity.ok(service.edit(ramDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
