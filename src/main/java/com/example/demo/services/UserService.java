package com.example.demo.services;

import com.example.demo.models.dtos.UserDTO;
import com.example.demo.models.entities.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO save(UserDTO userDTO){
        return UserDTO.fromEntity(repository.save(User.fromDTO(userDTO)));
    }

    public List<UserDTO> findAll(){
        return repository.findAll().stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }

    public UserDTO findById(Integer id){
        return UserDTO.fromEntity(repository.findById(id).orElseThrow(NoSuchFieldError::new));
    }

    public UserDTO edit(UserDTO userDTO){
        return UserDTO.fromEntity(repository.save(User.fromDTO(userDTO)));
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}

