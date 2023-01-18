package com.loginAuthentication.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataCreateUser(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotNull
        Integer phone,
        @NotNull
        String bio,
        @NotBlank
        String username,
        @NotBlank
        @Pattern(regexp = "\\d{4,20}")
        String password

) {
}