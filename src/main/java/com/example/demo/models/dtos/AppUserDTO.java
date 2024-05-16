package com.example.demo.models.dtos;

import com.example.demo.models.entities.AppUser;

public class AppUserDTO {
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

    public AppUserDTO(Integer id, String name, boolean admin, String password){
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.password = password;
    }

    public static AppUserDTO fromEntity(AppUser appUser){
        return new AppUserDTO(
                appUser.getId(),
                appUser.getName(),
                appUser.isAdmin(),
                appUser.getPassword()
        );
    }
}
