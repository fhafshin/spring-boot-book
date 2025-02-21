package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotNull(message = "{username.is.null}") @NotBlank(message = "{username.is.blank}") String username,
        @NotNull(message = "{password.is.null}") @NotBlank(message = "{password.is.blank}") String password) {
}
