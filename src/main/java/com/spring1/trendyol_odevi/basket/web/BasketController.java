package com.spring1.trendyol_odevi.basket.web;

import com.spring1.trendyol_odevi.basket.api.BasketService;
import com.spring1.trendyol_odevi.user.impl.User;
import com.spring1.trendyol_odevi.basket.api.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baskets")
public class BasketController {
    @Autowired
    BasketService basketService;

    @PostMapping
    public BasketResponse save(@RequestBody BasketRequest basketRequest) {
        BasketDTO savedBasket = basketService.addProductToBasket(basketRequest.getProductId() ,basketRequest.getUserId());
        return toResponse(savedBasket);
    }

    @GetMapping("/{user}")
    public BasketResponse getByUser(@PathVariable("user") User user) {
        BasketDTO basketDTO = basketService.findByUser(user);
        return toResponse(basketDTO);
    }

    private BasketDTO toDto(BasketRequest request) {
        BasketDTO dto = new BasketDTO();
        dto.setUserId(request.getUserId());
        dto.setBasketProducts(request.getBasketProducts());
        return dto;
    }

    private BasketResponse toResponse(BasketDTO dto) {
        BasketResponse response = new BasketResponse();
        response.setBasketId(dto.getBasketId());
        response.setUserId(dto.getUserId());
        response.setBasketAmount(dto.getBasketAmount());
        response.setBasketProducts(dto.getBasketProducts());
        return response;
    }
}
