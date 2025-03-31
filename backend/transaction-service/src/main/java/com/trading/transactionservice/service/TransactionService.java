package com.trading.transactionservice.service;

import com.trading.commonlibrary.model.TradeEvent;
import com.trading.transactionservice.model.Transaction;
import com.trading.transactionservice.repository.TransactionRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    @KafkaListener(topics = "trade-events", groupId = "transaction-consumers", containerFactory = "kafkaListenerContainerFactory")
    public void saveTrade(TradeEvent event) {
        Transaction transaction = new Transaction();
        transaction.setUserId(event.getUserId());
        transaction.setCryptoSymbol(event.getCryptoSymbol());
        transaction.setTradeType(event.getTradeType());
        transaction.setAmount(event.getAmount());
        transaction.setPricePerUnit(event.getPricePerUnit());
        transaction.setTimestamp(event.getTimestamp());

        repository.save(transaction);
        System.out.println("Trade trnsaction saved for "+ event.getCryptoSymbol());
    }

}
