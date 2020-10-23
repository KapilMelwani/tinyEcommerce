package com.mhp.solutions.tiny.ecommerce.services;

import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;

import java.util.List;

public interface IProductsService {
    List<ProductsDto> findAll();
    ProductsDto getProductByName(String name);
    ProductsDto getProductById(Long idProduct);
    List<ProductsDto> getProductsByPriceLessThan(Double priceLessThan);
    List<ProductsDto> getProductsByPriceGreaterThan(Double priceGreaterThan);
    List<ProductsDto> getProductsByProductCategory(String category);
    List<ProductsDto> getProductsByStockLessThanEqual(Integer stockLessThan);
    List<ProductsDto> getProductsByStockGreaterThanEqual(Integer stockGreaterThan);
    void addProduct(ProductsDto productsDto);
    void updateProduct(ProductsDto productsDto);
    void deleteProductById(Long idProduct);
}
