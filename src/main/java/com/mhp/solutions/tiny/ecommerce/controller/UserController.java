package com.mhp.solutions.tiny.ecommerce.controller;

import com.mhp.solutions.tiny.ecommerce.api.ApiError;
import com.mhp.solutions.tiny.ecommerce.api.ApiSuccess;
import com.mhp.solutions.tiny.ecommerce.controller.util.UtilController;
import com.mhp.solutions.tiny.ecommerce.entities.Roles;
import com.mhp.solutions.tiny.ecommerce.entities.dto.AdministatorsDto;
import com.mhp.solutions.tiny.ecommerce.entities.dto.CustomersDto;
import com.mhp.solutions.tiny.ecommerce.entities.dto.UserDto;
import com.mhp.solutions.tiny.ecommerce.services.IAdministratorService;
import com.mhp.solutions.tiny.ecommerce.services.ICustomerService;
import com.mhp.solutions.tiny.ecommerce.services.IUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends UtilController {
    @Autowired
    IUserService userService;
    @Autowired
    IAdministratorService administratorService;
    @Autowired
    ICustomerService customerService;
    private final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(method = RequestMethod.POST, value = "/administrator/new")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> addAdministrator(@RequestBody final UserDto user) {
        try {
            user.setRol(Roles.ADMINISTRATOR);
            userService.addUser(user);
            final AdministatorsDto administatorsDto = new AdministatorsDto();
            administatorsDto.setUser(user);
            administatorsDto.setId(user.getId());
            administratorService.addAdministrator(administatorsDto);
            return new ResponseEntity<>(
                    new ApiSuccess(user.getId(), "Administrator created."), HttpStatus.CREATED);

        } catch (final Exception e) {
            logger.error("[CREATE_ADMINISTRATOR_ERROR] Error creating administrator: " + e);
            return new ResponseEntity<>(
                    new ApiError("CREATE_EMPLOYEE_ERROR", "Error creating administrator: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customer/new")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<?> addCustomer(@RequestBody final UserDto user) {
        try {
            user.setRol(Roles.CUSTOMER);
            userService.addUser(user);
            final CustomersDto customersDto = new CustomersDto();
            customersDto.setUser(user);
            customersDto.setId(user.getId());
            customerService.addCustomer(customersDto);
            return new ResponseEntity<>(
                    new ApiSuccess(user.getId(), "Customer created."), HttpStatus.CREATED);

        } catch (final Exception e) {
            logger.error("[CREATE_ADMINISTRATOR_ERROR] Error creating customer: " + e);
            return new ResponseEntity<>(
                    new ApiError("CREATE_EMPLOYEE_ERROR", "Error creating customer: " + e),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
