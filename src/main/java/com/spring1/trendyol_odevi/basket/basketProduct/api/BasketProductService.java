package com.spring1.trendyol_odevi.basket.basketProduct.api;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;

import java.util.List;

public interface BasketProductService {
    BasketProductDTO save(BasketProductDTO basketProductDTO);
    BasketProductDTO findById(String id);
    List<BasketProduct> toDtoList(List<BasketProduct> basketProducts);
    BasketProduct toEntity(BasketProductDTO dto);
    BasketProductDTO toDto(BasketProduct basketProduct);
}
