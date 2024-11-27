package com.spring1.trendyol_odevi.basket.api;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
import com.spring1.trendyol_odevi.basket.impl.Basket;
import com.spring1.trendyol_odevi.basket.web.BasketRequest;
import com.spring1.trendyol_odevi.user.impl.User;

import java.util.List;

public interface BasketService {
    public BasketDTO addProductToBasket(int productId, String userId);

    public BasketDTO findByUser(User user);

    BasketDTO saveBasket(BasketRequest request);

    List<BasketProduct> updateBasket(Basket basket, BasketRequest request);

    BasketProduct createBasketProduct(int productID, int count);

    Basket createNewBasket(User user, BasketRequest request);

    float calcTotalBasketAmount(Basket basket);

    Basket toEntity(BasketDTO dto);

    BasketDTO toDto(Basket basket);

    List<BasketDTO> toDtoList(List<Basket> basketList);

}
