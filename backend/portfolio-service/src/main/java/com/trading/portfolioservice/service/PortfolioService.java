package com.trading.portfolioservice.service;

import com.trading.commonlibrary.model.TradeEvent;
import com.trading.portfolioservice.model.Portfolio;
import com.trading.portfolioservice.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioService {
    private final PortfolioRepository repository;

    public PortfolioService(PortfolioRepository repository) {
        this.repository = repository;
    }

    public void updatePortfolio(TradeEvent event) {
        Optional<Portfolio> existing = repository.findByUserIdAndCryptoSymbol(event.getUserId(), event.getCryptoSymbol());

        Portfolio portfolio = existing.orElseGet(() -> {
            Portfolio p = new Portfolio();
            p.setUserId(event.getUserId());
            p.setCryptoSymbol(event.getCryptoSymbol());
            p.setQuantity(0.0);
            return p;
        });

        double updatedQty = portfolio.getQuantity();

        if (event.getTradeType().equalsIgnoreCase("BUY")) {
            updatedQty += event.getAmount();
        } else if (event.getTradeType().equalsIgnoreCase("SELL")) {
            updatedQty -= event.getAmount();
        }

        portfolio.setQuantity(updatedQty);
        repository.save(portfolio);
    }
}
