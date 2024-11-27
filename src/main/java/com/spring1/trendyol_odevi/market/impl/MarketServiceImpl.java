package com.spring1.trendyol_odevi.market.impl;

import com.spring1.trendyol_odevi.category.api.CategoryDTO;
import com.spring1.trendyol_odevi.category.impl.Category;
import com.spring1.trendyol_odevi.category.impl.CategoryServiceImpl;
import com.spring1.trendyol_odevi.market.api.MarketDTO;
import com.spring1.trendyol_odevi.market.api.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarketServiceImpl implements MarketService {

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private CategoryServiceImpl categoryService;  // Injecting CategoryServiceImpl to reuse its conversion methods

    @Override
    public MarketDTO save(MarketDTO marketDTO) {
        Market market = toEntity(marketDTO);
        Market savedMarket = marketRepository.save(market);
        return toDto(savedMarket);
    }

    @Override
    public MarketDTO findById(String marketId) {
        Optional<Market> marketOptional = marketRepository.findById(marketId);
        if (marketOptional.isPresent()) {
            return toDto((Market) marketOptional.get());
        } else {
            throw new RuntimeException("Market not found with ID: " + marketId);
        }
    }

    @Override
    public List<MarketDTO> findAll() {
        List<Market> markets = marketRepository.findAll();
        return markets.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String marketId) {
        if (marketRepository.existsById(marketId)) {
            marketRepository.deleteById(marketId);
        } else {
            throw new RuntimeException("Market not found with ID: " + marketId);
        }
    }

    private Market toEntity(MarketDTO dto) {
        Market market = new Market();
        market.setMarketId(dto.getMarketId());
        // Convert each CategoryDTO to Category entity using CategoryService
        market.setCategories(dto.getCategories()
                .stream()
                .map((Category categoryDTO) -> toCategoryEntity(categoryDTO)) // This maps each CategoryDTO to Category entity
                .collect(Collectors.toList()));
        return market;
    }

    private Category toCategoryEntity(CategoryDTO categoryDTO) {
        return categoryService.toEntity(categoryDTO);
    }

    private MarketDTO toDto(Market market) {
        MarketDTO dto = new MarketDTO();
        dto.setMarketId(market.getMarketId());
        dto.setCategories(market.getCategories()
                .stream()
                .map(this::toCategoryDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    // Converts a Category entity to a CategoryDTO
    private CategoryDTO toCategoryDTO(Category category) {
        return categoryService.toDto(category);
    }
}
