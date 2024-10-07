package com.spring1.trendyol_odevi.controller;

import com.spring1.trendyol_odevi.controller.request.MarketRequest;
import com.spring1.trendyol_odevi.controller.response.MarketResponse;
import com.spring1.trendyol_odevi.service.MarketService;
import com.spring1.trendyol_odevi.service.dto.MarketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/markets")
public class MarketController {
    @Autowired
    MarketService marketService;

    @PostMapping
    public MarketResponse save(@RequestBody MarketRequest marketRequest) {
        MarketDTO savedMarket = marketService.save(toDto(marketRequest));
        return toResponse(savedMarket);
    }

    @GetMapping("/{id}")
    public MarketResponse getById(@PathVariable("id") String id) {
        MarketDTO MarketDTO = marketService.findById(id);
        return toResponse(MarketDTO);
    }

    private MarketDTO toDto(MarketRequest request) {
        MarketDTO dto = new MarketDTO();
        dto.setMarketId(request.getMarketId());
        dto.setCategories(request.getCategories());
        return dto;
    }

    private MarketResponse toResponse(MarketDTO dto) {
        MarketResponse response = new MarketResponse();
        response.setMarketId(dto.getMarketId());
        response.setMarketId(dto.getMarketId());
        response.setCategories(dto.getCategories());
        return response;
    }
}
