package com.trading.notificationservice.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender sender;

    public EmailService(JavaMailSender sender) {
        this.sender = sender;
    }

    public void sendTradeAlert(String to, String Subject, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ankit245202@gmail.com");
        message.setTo(to);
        message.setSubject(Subject);
        message.setText(content);

        sender.send(message);
        System.out.println("Email alert sent to" + to);
    }

}
