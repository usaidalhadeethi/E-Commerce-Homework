package com.spring1.trendyol_odevi.service;

import com.spring1.trendyol_odevi.entity.Basket;
import com.spring1.trendyol_odevi.repository.BasketRepository;
import com.spring1.trendyol_odevi.service.dto.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    public BasketDTO save(BasketDTO dto) {
        Basket basket = toEntity(dto);
        basketRepository.save(basket);
        return toDto(basket);
    }

    public BasketDTO findById(String id) {
        Basket basket = basketRepository.findById(Integer.parseInt(id)).orElse(null);
        return toDto(basket);
    }

    private Basket toEntity(BasketDTO dto) {
        Basket basket = new Basket();
        basket.setUserId(dto.getUserId());
        return basket;
    }

    private BasketDTO toDto(Basket basket) {
        BasketDTO dto = new BasketDTO();
        dto.setBasketId(basket.getBasketId());
        dto.setUserId(basket.getUserId());
        return dto;
    }
}
