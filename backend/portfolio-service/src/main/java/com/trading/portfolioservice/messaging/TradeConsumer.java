package com.trading.portfolioservice.messaging;

import com.trading.commonlibrary.model.TradeEvent;
import com.trading.portfolioservice.service.PortfolioService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TradeConsumer {

    private final PortfolioService portfolioService;

    public TradeConsumer(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @KafkaListener(topics = "trade-events", groupId = "crypto-consumers-v2", containerFactory = "kafkaListenerContainerFactory")
    public void listen(TradeEvent event) {
        portfolioService.updatePortfolio(event);
        System.out.println("Portfolio updated for user: " + event.getUserId());
    }
}
