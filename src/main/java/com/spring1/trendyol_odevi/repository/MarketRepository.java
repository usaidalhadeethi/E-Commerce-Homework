package com.spring1.trendyol_odevi.repository;

import com.spring1.trendyol_odevi.entity.Market;
import com.spring1.trendyol_odevi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketRepository extends JpaRepository<MarketRepository, String> {
    public Optional<Market> findById (int marketId);
}
