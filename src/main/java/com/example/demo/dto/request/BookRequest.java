package com.example.demo.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequest(@NotNull(message = "{book.is.null}") @NotBlank(message = "{book.is.blank}") String name,
                          @NotNull(message = "{price.is.null}")  @Min(value = 0, message = "{price.min}") Long price) {

}
