package com.spring1.trendyol_odevi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Basket {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String basketId;
    private float basketAmount;
    private String userId;

    @OneToMany (mappedBy = "basket")
    private List<BasketProduct> basketProducts;


//    @ManyToOne
//    @JoinColumn (name = "userId")
//    private User user;

    public Basket() {
    }

    public Basket(String basketId, float basketAmount, List<BasketProduct> basketProducts, String userId) {
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
