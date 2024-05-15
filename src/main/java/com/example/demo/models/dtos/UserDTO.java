package com.example.demo.models.dtos;

import com.example.demo.models.entities.User;

public class UserDTO {
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

    public UserDTO(Integer id, String name, boolean admin, String password){
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.password = password;
    }

    public static UserDTO fromEntity(User user){
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.isAdmin(),
                user.getPassword()
        );
    }
}
