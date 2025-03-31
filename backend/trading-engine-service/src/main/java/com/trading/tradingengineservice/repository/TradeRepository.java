package com.trading.tradingengineservice.repository;

import com.trading.tradingengineservice.model.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<TradeEntity, Long> {
}
