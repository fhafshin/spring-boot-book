package com.example.demo.service.user;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

public interface UserService {

    UserResponse save(UserRequest user);
}
