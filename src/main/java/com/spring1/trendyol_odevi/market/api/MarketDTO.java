package com.spring1.trendyol_odevi.market.api;

import com.spring1.trendyol_odevi.category.api.CategoryDTO;
import com.spring1.trendyol_odevi.category.impl.Category;
import java.util.List;

public class MarketDTO {
    private String marketId;
    private List<Category> categories;

    public MarketDTO() {
    }

    public MarketDTO(String marketId, List<Category> categories) {
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

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }
}
