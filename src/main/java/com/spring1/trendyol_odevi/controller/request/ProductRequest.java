package com.spring1.trendyol_odevi.controller.request;

import com.spring1.trendyol_odevi.entity.BasketProduct;
import com.spring1.trendyol_odevi.entity.Category;

public class ProductRequest {
    private String productId;
    private String productName;
    private Category category;
    private BasketProduct basketProduct;

    public ProductRequest() {
    }

    public ProductRequest(String productId, String productName, Category category, BasketProduct basketProduct) {
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
