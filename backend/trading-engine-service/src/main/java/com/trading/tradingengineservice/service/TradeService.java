package com.trading.tradingengineservice.service;


import com.trading.tradingengineservice.model.TradeEntity;
import com.trading.tradingengineservice.repository.TradeRepository;
import com.trading.commonlibrary.model.TradeEvent;
import org.springframework.stereotype.Service;

@Service
public class TradeService {

    private final TradeRepository repository;

    public TradeService(TradeRepository repository) {
        this.repository = repository;
    }

    public void saveTrade(TradeEvent event) {
        TradeEntity entity = new TradeEntity();
        entity.setUserId(event.getUserId());
        entity.setCryptoSymbol(event.getCryptoSymbol());
        entity.setTradeType(event.getTradeType());
        entity.setAmount(event.getAmount());
        entity.setPricePerUnit(event.getPricePerUnit());
        entity.setTimestamp(event.getTimestamp());
        repository.save(entity);
    }
}
