package com.example.demo.service.user;

import com.example.demo.dto.request.UserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.entities.User;
import com.example.demo.exception.RuleException;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest user) {

        Optional<User> username = userRepository.findByUsername(user.username());
        if (username.isPresent())
            throw new RuleException("user.is.exist");

        var newUser = userRepository.save(createUserRequest(user));
        return createUserResponse(newUser);
    }

    private User createUserRequest(UserRequest userRequest){

        return  User.builder().username(userRequest.username())
                .password(userRequest.password())
                .build();
    }

    private UserResponse createUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .build();
    }
}
