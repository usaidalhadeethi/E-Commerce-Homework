package com.spring1.trendyol_odevi.controller;

import com.spring1.trendyol_odevi.controller.request.BasketRequest;
import com.spring1.trendyol_odevi.controller.response.BasketResponse;
import com.spring1.trendyol_odevi.service.BasketService;
import com.spring1.trendyol_odevi.service.dto.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    BasketService basketService;

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basketRequest) {
        BasketDTO savedBasket = basketService.save(toDto(basketRequest));
        return toResponse(savedBasket);
    }

    @GetMapping("/{id}")
    public BasketResponse getById(@PathVariable("id") String id) {
        BasketDTO BasketDTO = basketService.findById(id);
        return toResponse(BasketDTO);
    }

    private BasketDTO toDto(BasketRequest request) {
        BasketDTO dto = new BasketDTO();
        dto.setUserId(request.getUserId());
        return dto;
    }

    private BasketResponse toResponse(BasketDTO dto) {
        BasketResponse response = new BasketResponse();
        response.setBasketId(dto.getBasketId());
        response.setUserId(dto.getUserId());
        return response;
    }
}
