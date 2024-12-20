package com.spring1.trendyol_odevi.category.api;

import com.spring1.trendyol_odevi.market.impl.Market;
import com.spring1.trendyol_odevi.Product.impl.Product;
import java.util.List;

public class CategoryDTO {
    private String categoryId;
    private String categoryName;
    private List<Product> products;
    private Market market;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryId, String categoryName, List<Product> products, Market market) {
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
