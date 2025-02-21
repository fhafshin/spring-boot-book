package com.example.demo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ShoppingRequest(@NotNull(message = "{userId.is.null}") Long userId,
                              @NotNull(message = "{bookId.is.null}") Long bookId,
                              @NotNull(message = "{countId.is.null}") @Min(value = 1, message = "{count.is.not.valid}") Integer count) {
}
