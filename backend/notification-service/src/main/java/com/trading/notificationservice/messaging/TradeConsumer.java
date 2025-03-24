package com.trading.notificationservice.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeConsumer {

    @KafkaListener(topics = "trade-events", groupId="stock-consumer-group")
    public void consume(String message){
        System.out.println("📥 Notification received: " + message);
        // You can parse JSON and send notification here later
    }
}
