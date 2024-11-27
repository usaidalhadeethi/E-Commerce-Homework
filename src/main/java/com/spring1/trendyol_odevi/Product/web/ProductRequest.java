package com.spring1.trendyol_odevi.Product.web;


import com.spring1.trendyol_odevi.category.impl.Category;

public class ProductRequest {
    private String productId;
    private String productName;
    private double price;
    private Category category;

    public ProductRequest() {
    }

    public ProductRequest(String productId, String productName, double price, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // Getters and Setters
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
