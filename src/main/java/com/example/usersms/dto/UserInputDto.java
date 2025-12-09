package com.example.usersms.dto;

import jakarta.validation.constraints.NotEmpty;

public class UserInputDto {
    @NotEmpty(message = "Email is mandatory")
    private String email;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Lastname is mandatory")
    private String lastname;

    @NotEmpty(message = "Username is mandatory")
    private String username;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
