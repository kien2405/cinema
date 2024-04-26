package com.example.ThucTapLTS.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


public class SignupRequest {
    private String username;
    @NotNull(message = "Password not null")
    @NotEmpty(message = "Password not empty")
    @Length(min = 8)
    private String password;
    @NotNull(message = "Email not null")
    @NotEmpty(message = "Email not empty")
    @Email(message = "Email invalid format")
    private String email;

    private String name;

    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
