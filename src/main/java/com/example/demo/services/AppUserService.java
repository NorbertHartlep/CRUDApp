package com.example.demo.services;

import com.example.demo.models.dtos.AppUserDTO;
import com.example.demo.models.entities.AppUser;
import com.example.demo.repositories.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserService {
    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public AppUserDTO save(AppUserDTO appUserDTO){
        return AppUserDTO.fromEntity(repository.save(AppUser.fromDTO(appUserDTO)));
    }

    public List<AppUserDTO> findAll(){
        return repository.findAll().stream().map(AppUserDTO::fromEntity).collect(Collectors.toList());
    }

    public AppUserDTO findById(Integer id){
        return AppUserDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public AppUserDTO edit(AppUserDTO appUserDTO){
        return AppUserDTO.fromEntity(repository.save(AppUser.fromDTO(appUserDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

