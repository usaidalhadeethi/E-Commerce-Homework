package com.spring1.trendyol_odevi.controller.request;

import com.spring1.trendyol_odevi.entity.Category;

import java.util.List;

public class MarketRequest {

    private String marketId;
    private List<Category> categories;

    public MarketRequest() {
    }

    public MarketRequest(String marketId, List<Category> categories) {
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
