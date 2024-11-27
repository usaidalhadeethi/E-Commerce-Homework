package com.spring1.trendyol_odevi.Product.api;

public interface ProductService {
    public ProductDTO save(ProductDTO dto);
    public ProductDTO findById(String id);
}
