package com.spring1.trendyol_odevi.Product.impl;

import com.spring1.trendyol_odevi.Product.api.ProductDTO;

import com.spring1.trendyol_odevi.Product.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    public ProductDTO save(ProductDTO dto) {
        Product product = toEntity(dto);
        productRepository.save(product);
        return toDto(product);
    }

    public ProductDTO findById(String id) {
        Product product = productRepository.findById(Integer.parseInt(id)).orElse(null);
        return toDto(product);
    }

    private Product toEntity(ProductDTO dto) {
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setProductId(dto.getProductId());
        product.setCategory(dto.getCategory());
        return product;
    }

    private ProductDTO toDto(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setProductId(product.getProductId());
        dto.setProductName(product.getProductName());
        dto.setCategory(product.getCategory());
        return dto;
    }
}
