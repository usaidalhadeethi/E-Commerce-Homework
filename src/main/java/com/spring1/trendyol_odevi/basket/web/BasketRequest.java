package com.spring1.trendyol_odevi.basket.web;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;

import java.util.List;

public class BasketRequest {
    private String basketId;
    private float basketAmount;
    private List<BasketProduct> basketProducts;
    private String userId;
    private String productId; // New field for productId

    public BasketRequest() {
    }

    public BasketRequest(String basketId, float basketAmount, List<BasketProduct> basketProducts, String userId, String productId) {
        this.basketId = basketId;
        this.basketAmount = basketAmount;
        this.basketProducts = basketProducts;
        this.userId = userId;
        this.productId = productId;
    }

    // Getter and Setter methods
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

    public int getProductId() { // Getter for productId
        return productId;
    }

    public void setProductId(String productId) { // Setter for productId
        this.productId = productId;
    }
}
