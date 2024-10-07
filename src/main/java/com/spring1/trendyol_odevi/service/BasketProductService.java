package com.spring1.trendyol_odevi.service;

import com.spring1.trendyol_odevi.entity.BasketProduct;
import com.spring1.trendyol_odevi.repository.BasketProductRepository;
import com.spring1.trendyol_odevi.service.dto.BasketProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketProductService {

    @Autowired
    BasketProductRepository basketProductRepository;

    public BasketProductDTO save(BasketProductDTO dto) {
        BasketProduct basketProduct = toEntity(dto);
//        basketProductRepository.save(basketProduct);  gives error
        return toDto(basketProduct);
    }

    public BasketProductDTO findById(String id) {
        BasketProduct basketProduct = basketProductRepository.findById(Integer.parseInt(id)).orElse(null);
        return toDto(basketProduct);
    }

    private BasketProduct toEntity(BasketProductDTO dto) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBasketId(dto.getBasketId());
        basketProduct.setProductId(dto.getProductId());
        return basketProduct;
    }

    private BasketProductDTO toDto(BasketProduct basketProduct) {
        BasketProductDTO dto = new BasketProductDTO();
        dto.setBasketProductId(basketProduct.getBasketProductId());
        dto.setBasketId(basketProduct.getBasketId());
        dto.setProductId(basketProduct.getProductId());
        return dto;
    }
}
