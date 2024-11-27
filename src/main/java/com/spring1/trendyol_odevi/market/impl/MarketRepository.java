package com.spring1.trendyol_odevi.market.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<Market, String> {
    public Optional<Market> findById (int marketId);
}
