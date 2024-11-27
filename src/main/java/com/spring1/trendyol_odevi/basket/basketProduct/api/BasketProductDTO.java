package com.spring1.trendyol_odevi.basket.basketProduct.api;

import com.spring1.trendyol_odevi.basket.impl.Basket;
//@Builder

public class BasketProductDTO {
    private String basketProductId;
    private int count;
    private double basketProductAmount;
    private String productId;
    private String basketId;
    private Basket basket;

    public BasketProductDTO() {
    }

    public BasketProductDTO(String basketProductId, int count, double basketProductAmount, String productId, String basketId) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.basketProductAmount = basketProductAmount;
        this.productId = productId;
        this.basketId = basketId;
    }

    public String getBasketProductId() {
        return basketProductId;
    }

    public void setBasketProductId(String basketProductId) {
        this.basketProductId = basketProductId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getBasketProductAmount() {
        return basketProductAmount;
    }

    public void setBasketProductAmount(double basketProductAmount) {
        this.basketProductAmount = basketProductAmount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }



}
