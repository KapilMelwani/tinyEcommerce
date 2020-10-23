package com.mhp.solutions.tiny.ecommerce.controller;

import com.mhp.solutions.tiny.ecommerce.api.ApiError;
import com.mhp.solutions.tiny.ecommerce.controller.util.UtilController;
import com.mhp.solutions.tiny.ecommerce.entities.dto.ProductsDto;
import com.mhp.solutions.tiny.ecommerce.services.ICustomerService;
import com.mhp.solutions.tiny.ecommerce.services.IProductsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController extends UtilController{
    @Autowired
    ICustomerService customerService;
    @Autowired
    IProductsService productsService;
    private final Log logger = LogFactory.getLog(getClass());

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @RequestMapping(method = RequestMethod.POST, value = "/api/products/all")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> getProductInfo(@RequestBody final Authentication authentication) {
        try {
            List<ProductsDto> productsDtoList = productsService.findAll();
            return new ResponseEntity<>(productsDtoList,HttpStatus.OK);
        } catch (final Exception e) {
            logger.error("[GET_ITEMS_ERROR] Error getting items: " + e);
            return new ResponseEntity<>(
                    new ApiError("GET_ITEMS_ERROR", "Error getting items: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
