package com.trading.tradingengineservice.messaging;

import com.trading.commonlibrary.model.TradeEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service

public class TradeProducer {
    private final KafkaTemplate<String, TradeEvent> kafkaTemplate;

    public TradeProducer(KafkaTemplate<String, TradeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTrade(TradeEvent event) {
        kafkaTemplate.send("trade-events", event);
    }
}
