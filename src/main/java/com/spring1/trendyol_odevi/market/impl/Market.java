package com.spring1.trendyol_odevi.market.impl;

import com.spring1.trendyol_odevi.category.impl.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Market {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String marketId;

    @OneToMany (mappedBy = "market")
    private List<Category> categories;

    public Market() {
    }

    public Market(String marketId, List<Category> categories) {
        this.marketId = marketId;
        this.categories = categories;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}