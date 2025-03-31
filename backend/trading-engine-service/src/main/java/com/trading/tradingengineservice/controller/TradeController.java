package com.trading.tradingengineservice.controller;

import com.trading.commonlibrary.model.TradeEvent;
import com.trading.tradingengineservice.messaging.TradeProducer;
import com.trading.tradingengineservice.service.TradeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/trade")
public class TradeController {
    private final TradeProducer tradeProducer;
    private final TradeService tradeService;

    public TradeController(TradeProducer tradeProducer, TradeService tradeService) {
        this.tradeProducer = tradeProducer;
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> placeTrade(@RequestBody TradeEvent event) {
        event.setTimestamp(System.currentTimeMillis());
        tradeService.saveTrade(event);         // ✅ Save to DB
        tradeProducer.sendTrade(event);        // ✅ Send to Kafka
        Map<String, String> response = new HashMap<>();
        response.put("message", "Trade placed for " + event.getCryptoSymbol());
        return ResponseEntity.ok(response);

    }

//    @PostMapping
//    public String sendTrade(@RequestBody String tradeJson){
//        tradeProducer.sendTrade(tradeJson);
//        return "Trade sent to Kafka";
//    }

//    @PostMapping
//    public ResponseEntity<String> placeTrade(@RequestBody TradeEvent tradeEvent){
//        tradeEvent.setTimestamp(System.currentTimeMillis());
//
//        tradeProducer.sendTrade(tradeEvent);
//        return ResponseEntity.ok("Trade placed for ")+ tradeEvent.getCryptoSymbol());
//    }
}
