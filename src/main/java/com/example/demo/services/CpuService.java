package com.example.demo.services;

import com.example.demo.models.dtos.CpuDTO;
import com.example.demo.models.entities.Cpu;
import com.example.demo.repositories.CpuRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CpuService {
    private final CpuRepository repository;

    public CpuService(CpuRepository repository) {
        this.repository = repository;
    }

    public CpuDTO save(CpuDTO cpuDTO){
        return CpuDTO.fromEntity(repository.save(Cpu.fromDto(cpuDTO)));
    }

    public List<CpuDTO> findAll(){
        return repository.findAll().stream().map(CpuDTO::fromEntity).collect(Collectors.toList());
    }

    public CpuDTO findById(Integer id){
        return CpuDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public CpuDTO edit(CpuDTO cpuDTO){
        return CpuDTO.fromEntity(repository.save(Cpu.fromDto(cpuDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
