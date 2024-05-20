package com.example.demo.services;

import com.example.demo.models.dtos.GpuDTO;
import com.example.demo.models.entities.Gpu;
import com.example.demo.repositories.GpuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GpuService {
    private final GpuRepository repository;

    public GpuService(GpuRepository repository) {
        this.repository = repository;
    }

    public GpuDTO save(GpuDTO gpuDTO){
        return GpuDTO.fromEntity(repository.save(Gpu.fromDto(gpuDTO)));
    }

    public List<GpuDTO> findAll(){
        return repository.findAll().stream().map(GpuDTO::fromEntity).collect(Collectors.toList());
    }

    public GpuDTO findById(Integer id){
        return GpuDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public GpuDTO edit(GpuDTO gpuDTO){
        return GpuDTO.fromEntity(repository.save(Gpu.fromDto(gpuDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
