package com.spring1.trendyol_odevi.Product.impl;
import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
import com.spring1.trendyol_odevi.category.impl.Category;
import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String productId;
    private String productName;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    public Product() {
    }

    public Product(String productId, String productName, double price, Category category, BasketProduct basketProduct) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
