package com.spring1.trendyol_odevi.basket.impl;

import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
import com.spring1.trendyol_odevi.user.impl.User;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String basketId;
    private float basketAmount;
    private int status;

    @OneToMany (mappedBy = "basket")
    private List<BasketProduct> basketProducts;


    @OneToOne (mappedBy = "basket")
    private User user;

    public Basket() {
    }

    public Basket(String basketId, float basketAmount, List<BasketProduct> basketProducts, User user) {
        this.basketId = basketId;
        this.basketAmount = basketAmount;
        this.basketProducts = basketProducts;
        this.user=user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
