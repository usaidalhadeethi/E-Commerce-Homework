package com.spring1.trendyol_odevi.basket.web;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;

import java.util.List;

public class BasketResponse {

    private String basketId;
    private float basketAmount;
    private List<BasketProduct> basketProducts;
    private String userId;
//    private User user;

    public BasketResponse() {
    }

    public BasketResponse(String basketId, float basketAmount, List<BasketProduct> basketProducts, String userId) {
        this.basketId = basketId;
        this.basketAmount = basketAmount;
        this.basketProducts = basketProducts;
        this.userId = userId;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public float getBasketAmount() {
        return basketAmount;
    }

    public void setBasketAmount(float basketAmount) {
        this.basketAmount = basketAmount;
    }

    public List<BasketProduct> getBasketProducts() {
        return basketProducts;
    }

    public void setBasketProducts(List<BasketProduct> basketProducts) {
        this.basketProducts = basketProducts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
