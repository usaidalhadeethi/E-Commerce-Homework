package com.spring1.trendyol_odevi.basket.api;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;

import java.util.List;

public class BasketDTO {
    private String basketId;
    private float basketAmount;
    private List<BasketProduct> basketProducts;
    private String userId;

    public static class Builder {
        private String basketId;
        private float basketAmount;
        private List<BasketProduct> basketProducts;
        private String userId;

        public Builder basketId(String basketId) {
            this.basketId = basketId;
            return this;
        }

        public Builder basketAmount(float basketAmount) {
            this.basketAmount = basketAmount;
            return this;
        }

        public Builder basketProducts(List<BasketProduct> basketProducts) {
            this.basketProducts = basketProducts;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public BasketDTO build() {
            return new BasketDTO(basketId, basketAmount, basketProducts, userId);
        }
    }

    public BasketDTO() {
    }

    public BasketDTO(String basketId, float basketAmount, List<BasketProduct> basketProducts, String userId) {
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
