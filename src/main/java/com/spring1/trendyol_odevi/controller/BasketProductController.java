package com.spring1.trendyol_odevi.controller;

import com.spring1.trendyol_odevi.controller.request.BasketProductRequest;
import com.spring1.trendyol_odevi.controller.response.BasketProductResponse;
import com.spring1.trendyol_odevi.service.BasketProductService;
import com.spring1.trendyol_odevi.service.dto.BasketProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket-products")
public class BasketProductController {
    @Autowired
    BasketProductService basketProductService;

    @PostMapping
    public BasketProductResponse save(@RequestBody BasketProductRequest basketProductRequest) {
        BasketProductDTO savedBasketProduct = basketProductService.save(toDto(basketProductRequest));
        return toResponse(savedBasketProduct);
    }

    @GetMapping("/{id}")
    public BasketProductResponse getById(@PathVariable("id") String id) {
        BasketProductDTO BasketProductDTO = basketProductService.findById(id);
        return toResponse(BasketProductDTO);
    }

    private BasketProductDTO toDto(BasketProductRequest request) {
        BasketProductDTO dto = new BasketProductDTO();
        dto.setBasketId(request.getBasketId());
        dto.setProductId(request.getProductId());
        return dto;
    }

    private BasketProductResponse toResponse(BasketProductDTO dto) {
        BasketProductResponse response = new BasketProductResponse();
        response.setBasketProductId(dto.getBasketProductId());
        response.setBasketId(dto.getBasketId());
        response.setProductId(dto.getProductId());
        return response;
    }
}
