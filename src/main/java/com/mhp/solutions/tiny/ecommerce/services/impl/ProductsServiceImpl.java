package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Products;
import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import com.mhp.solutions.tiny.ecommerce.repository.ProductsRepo;
import com.mhp.solutions.tiny.ecommerce.services.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService {

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public List<ProductsDto> findAll() {
        final List<Products> entities = productsRepo.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public ProductsDto getProductByName(String name) {
        Products entity = productsRepo.findProductsByProductName(name);
        ProductsDto productsDto = ObjectMapperUtils.map(entity,ProductsDto.class);
        return productsDto;
    }

    @Override
    public ProductsDto getProductById(Long idProduct) {
        Products entity = productsRepo.findProductsById(idProduct);
        ProductsDto productsDto = ObjectMapperUtils.map(entity,ProductsDto.class);
        return productsDto;
    }

    @Override
    public List<ProductsDto> getProductsByPriceLessThan(Double priceLessThan) {
        final List<Products> entities = productsRepo.findProductsByPriceLessThan(priceLessThan);
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByPriceGreaterThan(Double priceGreaterThan) {
        final List<Products> entities = productsRepo.findProductsByPriceGreaterThan(priceGreaterThan);
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByProductCategory(String category) {
        final List<Products> entities = productsRepo.findProductsByProductCategory(category);
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByStockLessThanEqual(Integer stockLessThan) {
        final List<Products> entities = productsRepo.findProductsByStockLessThanEqual(stockLessThan);
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByStockGreaterThanEqual(Integer stockGreaterThan) {
        final List<Products> entities = productsRepo.findProductsByStockGreaterThanEqual(stockGreaterThan);
        final List<ProductsDto> productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        return productsDtoList;
    }

    @Override
    public void addProduct(ProductsDto productsDto) {
        final Products entity = ObjectMapperUtils.map(productsDto, Products.class);
        productsRepo.save(entity);
        productsDto.setId(entity.getId());
    }

    @Override
    public void updateProduct(ProductsDto productsDto) {
        final Products entity = ObjectMapperUtils.map(productsDto, Products.class);
        productsRepo.save(entity);
        productsDto.setId(entity.getId());
    }

    @Override
    public void deleteProductById(Long idProduct) {
        productsRepo.deleteProductsById(idProduct);
    }
}
