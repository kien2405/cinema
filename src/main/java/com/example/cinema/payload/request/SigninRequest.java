package com.example.ThucTapLTS.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class SigninRequest {
    @NotNull(message = "Email not null")
    @NotEmpty(message = "Email not empty")
    @Email(message = "Email invalid format")
    private String email;

    @NotNull(message = "Password not null")
    @NotEmpty(message = "Password not empty")
    @Length(min = 8)
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
