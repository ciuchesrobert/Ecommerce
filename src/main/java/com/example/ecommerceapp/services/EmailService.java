package com.example.ecommerceapp.services;

import com.example.ecommerceapp.entities.MailModel;
import freemarker.template.TemplateException;

import javax.mail.MessagingException;
import java.io.IOException;

public interface EmailService {

    void  sendEmail(MailModel model) throws MessagingException, IOException, TemplateException;
}
