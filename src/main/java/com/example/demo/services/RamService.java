package com.example.demo.services;

import com.example.demo.models.dtos.RamDTO;
import com.example.demo.models.entities.Ram;
import com.example.demo.repositories.RamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RamService {
    private final RamRepository repository;

    public RamService(RamRepository repository) {
        this.repository = repository;
    }

    public RamDTO save(RamDTO ramDTO){
        return RamDTO.fromEntity(repository.save(Ram.fromDTO(ramDTO)));
    }

    public List<RamDTO> findAll(){
        return repository.findAll().stream().map(RamDTO::fromEntity).collect(Collectors.toList());
    }

    public RamDTO findById(Integer id){
        return RamDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public RamDTO edit(RamDTO ramDTO){
        return RamDTO.fromEntity(repository.save(Ram.fromDTO(ramDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

