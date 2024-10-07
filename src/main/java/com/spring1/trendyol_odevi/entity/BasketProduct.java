package com.spring1.trendyol_odevi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class BasketProduct {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String basketProductId;
    private int count;
    private double basketProductAmount;
    private String basketId;
    private String productId;

    @ManyToOne
    @JoinColumn (name = "productId")
    private Product product;

    @JoinColumn (name = "basketId")
    private Basket basket;

    public BasketProduct() {
    }

    public BasketProduct(String productId, String basketId, int count, String basketProductId, double basketProductAmount) {
        this.productId = productId;
        this.basketId = basketId;
        this.count = count;
        this.basketProductId = basketProductId;
        this.basketProductAmount = basketProductAmount;
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

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
