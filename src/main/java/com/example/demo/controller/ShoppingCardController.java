package com.example.demo.controller;

import com.example.demo.dto.request.ShoppingRequest;
import com.example.demo.dto.response.ShoppingResponse;
import com.example.demo.service.shopping.ShoppingCardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;

    private final LocalValidatorFactoryBean validator;

    public ShoppingCardController(ShoppingCardService shoppingCardService, @Qualifier("validator") LocalValidatorFactoryBean validator) {
        this.shoppingCardService = shoppingCardService;
        this.validator = validator;
    }

    public ResponseEntity<ShoppingResponse> addBook(@RequestBody @Valid ShoppingRequest shoppingRequest){


        return ResponseEntity.ok(shoppingCardService.addBook(shoppingRequest));
    }
}
