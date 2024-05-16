package com.example.demo.services;

import com.example.demo.models.dtos.MotherboardDTO;
import com.example.demo.models.entities.Motherboard;
import com.example.demo.repositories.MotherboardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotherboardService {
    private final MotherboardRepository repository;

    public MotherboardService(MotherboardRepository repository) {
        this.repository = repository;
    }

    public MotherboardDTO save(MotherboardDTO motherboardDTO){
        return MotherboardDTO.fromEntity(repository.save(Motherboard.fromDto(motherboardDTO)));
    }

    public List<MotherboardDTO> findAll(){
        return repository.findAll().stream().map(MotherboardDTO::fromEntity).collect(Collectors.toList());
    }

    public MotherboardDTO findById(Integer id){
        return MotherboardDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public MotherboardDTO edit(MotherboardDTO motherboardDTO){
        return MotherboardDTO.fromEntity(repository.save(Motherboard.fromDto(motherboardDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

