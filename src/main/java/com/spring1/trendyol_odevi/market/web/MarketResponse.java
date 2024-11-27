package com.spring1.trendyol_odevi.market.web;

import com.spring1.trendyol_odevi.category.impl.Category;

import java.util.List;

public class MarketResponse {

    private String marketId;
    private List<Category> categories;

    public MarketResponse() {
    }

    public MarketResponse(String marketId, List<Category> categories) {
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
