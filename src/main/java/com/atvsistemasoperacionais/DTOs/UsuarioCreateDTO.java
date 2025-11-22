package com.atvsistemasoperacionais.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public record UsuarioCreateDTO(
        @NotBlank
        @Size(min = 3, max = 255)
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha) {
}
