package com.example.demo.service.shopping;

import com.example.demo.dto.request.ShoppingRequest;
import com.example.demo.dto.response.ShoppingResponse;

public interface ShoppingCardService {
    ShoppingResponse addBook(ShoppingRequest shoppingRequest);
}
