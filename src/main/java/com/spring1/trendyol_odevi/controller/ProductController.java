package com.spring1.trendyol_odevi.controller;

import com.spring1.trendyol_odevi.controller.request.ProductRequest;
import com.spring1.trendyol_odevi.controller.response.ProductResponse;
import com.spring1.trendyol_odevi.service.ProductService;
import com.spring1.trendyol_odevi.service.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ProductResponse save(@RequestBody ProductRequest productRequest) {
        ProductDTO savedProduct = productService.save(toDto(productRequest));
        return toResponse(savedProduct);
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable("id") String id) {
        ProductDTO ProductDTO = productService.findById(id);
        return toResponse(ProductDTO);
    }

    private ProductDTO toDto(ProductRequest request) {
        ProductDTO dto = new ProductDTO();
        dto.setProductName(request.getProductName());
        dto.setProductId(request.getProductId());
        dto.setBasketProduct(request.getBasketProduct());
        dto.setCategory(request.getCategory());
        return dto;
    }

    private ProductResponse toResponse(ProductDTO dto) {
        ProductResponse response = new ProductResponse();
        response.setProductId(dto.getProductId());
        response.setProductName(dto.getProductName());
        response.setBasketProduct(dto.getBasketProduct());
        response.setCategory(dto.getCategory());
        return response;
    }
}
