package com.spring1.trendyol_odevi.service;

import com.spring1.trendyol_odevi.entity.Market;
import com.spring1.trendyol_odevi.repository.MarketRepository;
import com.spring1.trendyol_odevi.service.dto.MarketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketService {

    @Autowired
    MarketRepository marketRepository;

    public MarketDTO save(MarketDTO dto) {
        Market market = toEntity(dto);
//        marketRepository.save(market); makes error
        return toDto(market);
    }

    public MarketDTO findById(String id) {
        Market market = marketRepository.findById(Integer.parseInt(id)).orElse(null);
        return toDto(market);
    }

    private Market toEntity(MarketDTO dto) {
        Market market = new Market();
        market.setMarketId(dto.getMarketId());
        market.setCategories(dto.getCategories());
        return market;
    }

    private MarketDTO toDto(Market market) {
        MarketDTO dto = new MarketDTO();
        dto.setMarketId(market.getMarketId());
        dto.setCategories(market.getCategories());
        return dto;
    }
}
