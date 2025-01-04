package com.example.marriagehall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.marriagehall.modal.EmailDetails;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@Valid @RequestBody EmailDetails emailDetails) {
        try {
            // Construct the email message
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("itsmemdasar415@gmail.com");  // Static recipient (admin or predefined email)
            message.setSubject("Contact Form Submission");
            message.setText("Name: " + emailDetails.getName() + "\n" + 
                            "Email: " + emailDetails.getEmail() + "\n" + 
                            "Mobile: " + emailDetails.getMobile() + "\n\n" + 
                            "Message: " + emailDetails.getMessage());

            // Send the email
            javaMailSender.send(message);

            return ResponseEntity.status(HttpStatus.CREATED).body("Email sent successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to send email. Error: " + e.getMessage());
        }
    }
}
