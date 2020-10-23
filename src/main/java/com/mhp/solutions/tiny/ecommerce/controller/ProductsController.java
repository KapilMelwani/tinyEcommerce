package com.mhp.solutions.tiny.ecommerce.controller;

import com.mhp.solutions.tiny.ecommerce.api.ApiError;
import com.mhp.solutions.tiny.ecommerce.api.ApiSuccess;
import com.mhp.solutions.tiny.ecommerce.controller.util.UtilController;
import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministatorsDto;
import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import com.mhp.solutions.tiny.ecommerce.services.IAdministratorService;
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

@RestController
public class ProductsController extends UtilController {

    @Autowired
    IProductsService productsService;
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
            Long userId = getUserIdFromAuthenticationInfo(authentication);
            productsDto.setCreationDate(new Date());
            AdministatorsDto administatorsDto = administratorService.getAdministratorById(userId);
            administatorsDto.setNumProduct(administatorsDto.getNumProduct()+1);
            productsService.addProduct(productsDto);
            administratorService.updateAdministrator(administatorsDto);
            return new ResponseEntity<>(new ApiSuccess(productsDto.getId(), "Product added by " +  administatorsDto.getUser().getName() + "."),HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("[GET_ITEMS_ERROR] Error getting items: " + e);
            return new ResponseEntity<>(
                    new ApiError("GET_ITEMS_ERROR", "Error getting items: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}