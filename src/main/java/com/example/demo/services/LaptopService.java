package com.example.demo.services;

import com.example.demo.models.dtos.ComputerDTO;
import com.example.demo.models.entities.Computer;
import com.example.demo.repositories.ComputerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopService {
    private final ComputerRepository repository;

    public LaptopService(ComputerRepository repository) {
        this.repository = repository;
    }

    public ComputerDTO save(ComputerDTO computerDTO){
        return ComputerDTO.fromEntity(repository.save(Computer.fromDto(computerDTO)));
    }

    public List<ComputerDTO> findAll(){
        return repository.findAll().stream().map(ComputerDTO::fromEntity).collect(Collectors.toList());
    }

    public ComputerDTO findById(Integer id){
        return ComputerDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public ComputerDTO edit(ComputerDTO computerDTO){
        return ComputerDTO.fromEntity(repository.save(Computer.fromDto(computerDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

