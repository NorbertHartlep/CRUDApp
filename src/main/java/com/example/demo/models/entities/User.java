package com.example.demo.models.entities;

import com.example.demo.models.dtos.UserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class User {
   @Id
   @GeneratedValue
   private Integer id;
   private String name;
   private boolean admin;
   private String password;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getPassword() {
        return password;
    }

    public User(Integer id, String name, boolean admin, String password){
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.password = password;
    }
    public static User fromDTO(UserDTO userDTO){
        return new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.isAdmin(),
                userDTO.getPassword()
        );
    }
}
