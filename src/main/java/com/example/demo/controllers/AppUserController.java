package com.example.demo.controllers;

import com.example.demo.models.dtos.AppUserDTO;
import com.example.demo.models.entities.LoginRequest;
import com.example.demo.services.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {
    private final AppUserService service;

    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AppUserDTO> save(@RequestBody AppUserDTO appUserDTO){
        return ResponseEntity.ok(service.save(appUserDTO));
    }

    @GetMapping
    public ResponseEntity<List<AppUserDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<AppUserDTO> edit(@RequestBody AppUserDTO appUserDTO){
        return ResponseEntity.ok(service.edit(appUserDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @PostMapping("/login")
    public ResponseEntity<AppUserDTO> login(@RequestBody LoginRequest loginRequest) {
        try {
            AppUserDTO appUserDTO = service.findByNameAndPassword(loginRequest.getName(), loginRequest.getPassword());
            return ResponseEntity.ok(appUserDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(401).body(null);
        }
    }
}

