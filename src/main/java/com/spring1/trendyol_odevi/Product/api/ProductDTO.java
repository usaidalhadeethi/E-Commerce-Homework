package com.spring1.trendyol_odevi.Product.api;

import com.spring1.trendyol_odevi.Product.impl.Product;
import com.spring1.trendyol_odevi.basket.basketProduct.impl.BasketProduct;
import com.spring1.trendyol_odevi.category.impl.Category;

public class ProductDTO extends Product {
    private String productId;
    private String productName;
    private Category category;
    private BasketProduct basketProduct;
    private double price;

    public ProductDTO() {
    }

    public ProductDTO(String productId, String productName, Category category, BasketProduct basketProduct, double price) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.basketProduct = basketProduct;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
