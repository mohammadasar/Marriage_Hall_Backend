package com.example.marriagehall.modal;

import jakarta.validation.constraints.*;

public class EmailDetails {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email address is required")
    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Mobile number is required")
    private String mobile;

    @NotBlank(message = "Message is required")
    @Size(min = 10, message = "Message must be at least 10 characters long")
    private String message;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
