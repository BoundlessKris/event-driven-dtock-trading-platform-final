package com.trading.notificationservice.service;

import com.trading.commonlibrary.model.TradeEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AlertService {

    public final EmailService emailService;

    public AlertService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "trade-events", groupId = "notification-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void sendTradeAlert(TradeEvent event) {
        // Log to console
        System.out.println("🔔 ALERT: New Trade by " + event.getUserId() +
                " → " + event.getTradeType() + " " + event.getAmount() +
                " of " + event.getCryptoSymbol() + " @ $" + event.getPricePerUnit());

        // Email Content
        String subject = "🚨 New Crypto Trade Alert";
        String message = "🔔 A new trade has been placed:\n\n" +
                "User ID: " + event.getUserId() + "\n" +
                "Crypto: " + event.getCryptoSymbol() + "\n" +
                "Type: " + event.getTradeType() + "\n" +
                "Amount: " + event.getAmount() + "\n" +
                "Price per Unit: $" + event.getPricePerUnit() + "\n" +
                "Time: " + new java.util.Date(event.getTimestamp());

        // Send email
        emailService.sendTradeAlert("ay82933@gmail.com", subject, message);
    }
}

