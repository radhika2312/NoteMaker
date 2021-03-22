package com.example.notemaker.model;

public class user {
    private String id;
    private String username;
    private String email;

    public user()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public user(String id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }


}
