package com.example.demo.models.entities;

import com.example.demo.models.dtos.AppUserDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AppUser {
   @Id
   @GeneratedValue
   private Integer id;
   private String name;
   private boolean admin;
   private String password;

    public AppUser() {
    }

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

    public AppUser(Integer id, String name, boolean admin, String password){
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.password = password;
    }
    public static AppUser fromDTO(AppUserDTO appUserDTO){
        return new AppUser(
                appUserDTO.getId(),
                appUserDTO.getName(),
                appUserDTO.isAdmin(),
                appUserDTO.getPassword()
        );
    }
}
