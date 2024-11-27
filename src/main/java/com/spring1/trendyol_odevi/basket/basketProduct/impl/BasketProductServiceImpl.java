package com.spring1.trendyol_odevi.basket.basketProduct.impl;

import com.spring1.trendyol_odevi.basket.basketProduct.api.BasketProductDTO;
import com.spring1.trendyol_odevi.basket.basketProduct.api.BasketProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BasketProductServiceImpl implements BasketProductService {

    @Autowired
    private BasketProductRepository basketProductRepository;

    @Override
    public BasketProductDTO save(BasketProductDTO basketProductDTO) {
        BasketProduct basketProduct = toEntity(basketProductDTO);
        BasketProduct savedBasketProduct = basketProductRepository.save(basketProduct);
        return toDto(savedBasketProduct);
    }

    @Override
    public BasketProductDTO findById(String id) {
        Optional<BasketProduct> basketProductOptional = basketProductRepository.findById(id);
        if (basketProductOptional.isPresent()) {
            return toDto(basketProductOptional.get());
        } else {
            throw new RuntimeException("BasketProduct not found with ID: " + id);
        }
    }

    public List<BasketProduct> toDtoList(List<BasketProduct> basketProducts) {
        return basketProducts.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BasketProduct toEntity(BasketProductDTO dto) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setBasketProductId(dto.getBasketProductId());
        basketProduct.setBasketId(dto.getBasketId());
        basketProduct.setProductId(dto.getProductId());
        basketProduct.setCount(dto.getCount());
        basketProduct.setBasketProductAmount(dto.getBasketProductAmount());
        return basketProduct;
    }

    public BasketProductDTO toDto(BasketProduct basketProduct) {
        BasketProductDTO dto = new BasketProductDTO();
        dto.setBasketProductId(basketProduct.getBasketProductId());
        dto.setBasketId(basketProduct.getBasketId());
        dto.setProductId(basketProduct.getProductId());
        dto.setCount(basketProduct.getCount());
        dto.setBasketProductAmount(basketProduct.getBasketProductAmount());
        return dto;
    }
}
