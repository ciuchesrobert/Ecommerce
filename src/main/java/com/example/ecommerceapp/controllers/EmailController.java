package com.example.ecommerceapp.controllers;

import com.example.ecommerceapp.entities.MailModel;
import com.example.ecommerceapp.services.EmailService;
import freemarker.template.TemplateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("email")
    public ResponseEntity<?> sendEmail(@RequestBody MailModel mailModel){
        try {
            emailService.sendEmail(mailModel);
            return ResponseEntity.ok().body(mailModel.toString());
        } catch (TemplateException | IOException | javax.mail.MessagingException e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }
}
