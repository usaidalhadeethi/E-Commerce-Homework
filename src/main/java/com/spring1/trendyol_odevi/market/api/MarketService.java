package com.spring1.trendyol_odevi.market.api;

import java.util.List;

public interface MarketService {
    MarketDTO save(MarketDTO marketDTO);
    MarketDTO findById(String marketId);
    List<MarketDTO> findAll();
    void deleteById(String marketId);
}
