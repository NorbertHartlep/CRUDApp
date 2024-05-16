package com.example.demo.controllers;

import com.example.demo.models.dtos.UserDTO;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.save(userDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<UserDTO> edit(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(service.edit(userDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
