package com.trading.portfolioservice.repository;

import com.trading.portfolioservice.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByUserIdAndCryptoSymbol(String userId, String cryptoSymbol);
}
