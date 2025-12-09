package com.example.usersms.dto;

public class UserOutputDto {
    private long id;
    private String email;
    private String name;
    private String lastname;
    private String username;

    public UserOutputDto(long id, String email, String name, String lastname, String username) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
