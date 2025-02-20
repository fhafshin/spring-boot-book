package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record UserRequest(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
}
