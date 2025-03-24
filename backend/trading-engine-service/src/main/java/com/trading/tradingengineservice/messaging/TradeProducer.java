package com.trading.tradingengineservice.messaging;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class TradeProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public TradeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTrade(String tradeJson) {
        kafkaTemplate.send("trade-events", tradeJson);
    }
}
