package com.spring1.trendyol_odevi.controller.response;

import com.spring1.trendyol_odevi.entity.Market;
import com.spring1.trendyol_odevi.entity.Product;

import java.util.List;

public class CategoryResponse {

    private String categoryId;
    private String categoryName;
    private List<Product> products;
    private Market market;

    public CategoryResponse() {
    }

    public CategoryResponse(String categoryId, String categoryName, List<Product> products, Market market) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
        this.market = market;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
