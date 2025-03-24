package com.trading.tradingengineservice.controller;

import com.trading.tradingengineservice.messaging.TradeProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trade")
public class TradeController {
    private final TradeProducer producer;

    public TradeController(TradeProducer producer) {
        this.producer=producer;
    }

    @PostMapping
    public String sendTrade(@RequestBody String tradeJson){
        producer.sendTrade(tradeJson);
        return "Trade sent to Kafka";
    }
}
