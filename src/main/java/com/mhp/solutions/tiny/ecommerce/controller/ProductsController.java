package com.mhp.solutions.tiny.ecommerce.controller;

import com.mhp.solutions.tiny.ecommerce.api.ApiError;
import com.mhp.solutions.tiny.ecommerce.api.ApiSuccess;
import com.mhp.solutions.tiny.ecommerce.controller.util.UtilController;
import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministratorsDto;
import com.mhp.solutions.tiny.ecommerce.entities.dto.CategoryDto;
import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import com.mhp.solutions.tiny.ecommerce.services.IAdministratorService;
import com.mhp.solutions.tiny.ecommerce.services.ICategoryService;
import com.mhp.solutions.tiny.ecommerce.services.IProductsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProductsController extends UtilController {

    @Autowired
    IProductsService productsService;
    @Autowired
    ICategoryService categoryService;
    @Autowired
    IAdministratorService administratorService;

    private final Log logger = LogFactory.getLog(getClass());

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(method = RequestMethod.POST, value = "/api/products/new")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> getProductInfo(final Authentication authentication,@RequestBody ProductsDto productsDto) {
        if(productsDto==null) {
            return invalidParam("productsDto");
        }
        try {
            CategoryDto categoryDto = new CategoryDto();
            Long userId = getUserIdFromAuthenticationInfo(authentication);
            if(categoryService.existsInDb(productsDto.getProductCategory().getCategoryName())) {
                categoryDto = categoryService.getCategoryByName(productsDto.getProductCategory().getCategoryName());
            } else {
                categoryDto = new CategoryDto();
                categoryDto.setCategoryName(productsDto.getProductCategory().getCategoryName());
                categoryService.addCategory(categoryDto);
            }
            productsDto.setCreationDate(new Date());
            productsDto.setProductCategory(categoryDto);
            AdministratorsDto administratorsDto = administratorService.getAdministratorById(userId);
            productsDto.setProductOwner(administratorsDto);
            productsService.addProduct(productsDto);
            return new ResponseEntity<>(new ApiSuccess(productsDto.getId(), "Product added by " +  administratorsDto.getUser().getName() + "."),HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("[GET_ITEMS_ERROR] Error getting items: " + e);
            return new ResponseEntity<>(
                    new ApiError("GET_ITEMS_ERROR", "Error getting items: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(method = RequestMethod.POST, value = "/api/products/update")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> updateProductInfo(final Authentication authentication,@RequestBody ProductsDto productsDto) {
        if(productsDto==null) {
            return invalidParam("productsDto");
        }
        try {
            Long userId = getUserIdFromAuthenticationInfo(authentication);
            CategoryDto categoryDto = new CategoryDto();
            if(!categoryService.existsInDb(productsDto.getProductCategory().getCategoryName())) {
                categoryDto = new CategoryDto();
                categoryDto.setCategoryName(productsDto.getProductCategory().getCategoryName());
                categoryService.addCategory(categoryDto);
                productsDto.setProductCategory(categoryDto);
            }
            AdministratorsDto administratorsDto = administratorService.getAdministratorById(userId);
            productsDto.setProductOwner(administratorsDto);
            productsService.updateProduct(productsDto);
            return new ResponseEntity<>(
                    new ApiSuccess(productsDto.getId(), "Product updated."), HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("[UPDATE_ITEMS_ERROR] Error getting items: " + e);
            return new ResponseEntity<>(
                    new ApiError("UPDATE_ITEMS_ERROR", "Error getting items: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @RequestMapping(method = RequestMethod.GET, value = "/api/products/all")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> getProductsAdministrator(final Authentication authentication) {
        try {
            Long adminId = getUserIdFromAuthenticationInfo(authentication);
            List<ProductsDto> productsDtoList = productsService.getProductsByOwner(adminId);
            return new ResponseEntity<>(
                    productsDtoList, HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("[GET_ITEMS_ERROR] Error getting items: " + e);
            return new ResponseEntity<>(
                    new ApiError("GET_ITEMS_ERROR", "Error getting items: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}