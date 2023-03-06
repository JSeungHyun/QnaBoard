package com.example.QnaSoloProject.admin;

public enum admin {
    INSTANCE("admin@gmail.com");

    private final String email;

    private admin(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
