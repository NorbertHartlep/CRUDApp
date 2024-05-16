package com.example.demo.services;


import com.example.demo.models.dtos.LaptopDTO;
import com.example.demo.models.entities.Laptop;
import com.example.demo.repositories.LaptopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopService {
    private final LaptopRepository repository;

    public LaptopService(LaptopRepository repository) {
        this.repository = repository;
    }

    public LaptopDTO save(LaptopDTO laptopDTO){
        return LaptopDTO.fromEntity(repository.save(Laptop.fromDto(laptopDTO)));
    }

    public List<LaptopDTO> findAll(){
        return repository.findAll().stream().map(LaptopDTO::fromEntity).collect(Collectors.toList());
    }

    public LaptopDTO findById(Integer id){
        return LaptopDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public LaptopDTO edit(LaptopDTO laptopDTO){
        return LaptopDTO.fromEntity(repository.save(Laptop.fromDto(laptopDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

