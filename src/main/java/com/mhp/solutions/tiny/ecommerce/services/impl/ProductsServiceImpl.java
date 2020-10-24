package com.mhp.solutions.tiny.ecommerce.services.impl;

import com.mhp.solutions.tiny.ecommerce.config.ObjectMapperUtils;
import com.mhp.solutions.tiny.ecommerce.entities.Products;
import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import com.mhp.solutions.tiny.ecommerce.repository.ProductsRepo;
import com.mhp.solutions.tiny.ecommerce.services.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements IProductsService {

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public List<ProductsDto> findAll() {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findAll();
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public ProductsDto getProductByName(String name) {
        ProductsDto productsDto = new ProductsDto();
        Products entity = productsRepo.findProductsByProductName(name);
        if(entity!=null) {
            productsDto = ObjectMapperUtils.map(entity, ProductsDto.class);
        }
        return productsDto;
    }

    @Override
    public ProductsDto getProductById(Long idProduct) {
        ProductsDto productsDto = new ProductsDto();
        Products entity = productsRepo.findProductsById(idProduct);
        if(entity!=null) {
            productsDto = ObjectMapperUtils.map(entity, ProductsDto.class);
        }
        return productsDto;
    }

    @Override
    public List<ProductsDto> getProductsByPriceLessThan(Double priceLessThan) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByPriceLessThan(priceLessThan);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByPriceGreaterThan(Double priceGreaterThan) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByPriceGreaterThan(priceGreaterThan);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByProductCategory(String category) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByProductCategory(category);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByStockLessThanEqual(Integer stockLessThan) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByStockLessThanEqual(stockLessThan);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public List<ProductsDto> getProductsByStockGreaterThanEqual(Integer stockGreaterThan) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByStockGreaterThanEqual(stockGreaterThan);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
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
    public List<ProductsDto> getProductsByOwner(Long ownerId) {
        List<ProductsDto> productsDtoList = new ArrayList<>();
        final List<Products> entities = productsRepo.findProductsByProductOwnerId(ownerId);
        if(entities!=null && !entities.isEmpty()) {
            productsDtoList = ObjectMapperUtils.mapAll(entities, ProductsDto.class);
        }
        return productsDtoList;
    }

    @Override
    public void deleteProductById(Long idProduct) {
        productsRepo.deleteProductsById(idProduct);
    }
}
