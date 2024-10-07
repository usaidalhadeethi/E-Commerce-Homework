package com.spring1.trendyol_odevi.entity;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;
    private String productName;

    @ManyToOne
    @JoinColumn (name = "categoryId")
    private Category category;

    @OneToMany (mappedBy = "product")
    private BasketProduct basketProduct;

    public Product() {
    }

    public Product(String productId, String productName, float price, Category category, BasketProduct basketProduct) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.basketProduct = basketProduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BasketProduct getBasketProduct() {
        return basketProduct;
    }

    public void setBasketProduct(BasketProduct basketProduct) {
        this.basketProduct = basketProduct;
    }
}
