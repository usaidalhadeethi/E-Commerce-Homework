package com.spring1.trendyol_odevi.basket.basketProduct.impl;

import com.spring1.trendyol_odevi.Product.impl.Product;
import com.spring1.trendyol_odevi.basket.basketProduct.api.BasketProductDTO;
import com.spring1.trendyol_odevi.basket.impl.Basket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class BasketProduct extends BasketProductDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String basketProductId;
    private int count;
    private double basketProductAmount;

    @OneToOne
    private Product product;

    @ManyToOne
    @JoinColumn (name = "basketId")
    private Basket basket;

    public BasketProduct() {
    }

    public BasketProduct(String basketProductId, int count, double basketProductAmount, Product product, Basket basket) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.basketProductAmount = basketProductAmount;
        this.product = product;
        this.basket = basket;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
