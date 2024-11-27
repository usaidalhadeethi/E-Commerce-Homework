package com.spring1.trendyol_odevi.category.impl;

import com.spring1.trendyol_odevi.Product.impl.Product;
import com.spring1.trendyol_odevi.category.api.CategoryDTO;
import com.spring1.trendyol_odevi.market.impl.Market;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Category extends CategoryDTO {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String categoryId;
    private String categoryName;

    @OneToMany (mappedBy = "category")
    private List<Product> products;

    @ManyToOne
    @JoinColumn (name = "marketId")
    private Market market;


    public Category() {
    }

    public Category(String categoryId, String categoryName, List<Product> products, Market market) {
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
