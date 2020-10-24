package com.mhp.solutions.tiny.ecommerce.repository;

import com.mhp.solutions.tiny.ecommerce.entities.Orders;
import com.mhp.solutions.tiny.ecommerce.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepo extends JpaRepository<Products,Long> {
    Products findProductsByProductName(String name);
    Products findProductsById(Long idProduct);
    List<Products> findProductsByProductOwnerId(Long idOwner);
    List<Products> findProductsByPriceLessThan(Double priceLessThan);
    List<Products> findProductsByPriceGreaterThan(Double priceGreaterThan);
    List<Products> findProductsByProductCategory(String category);
    List<Products> findProductsByStockLessThanEqual(Integer stockLessThan);
    List<Products> findProductsByStockGreaterThanEqual(Integer stockGreaterThan);
    void deleteProductsById(Long idProduct);
}
