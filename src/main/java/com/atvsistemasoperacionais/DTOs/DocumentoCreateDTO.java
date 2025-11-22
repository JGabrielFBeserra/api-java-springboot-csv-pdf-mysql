package com.atvsistemasoperacionais.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DocumentoCreateDTO(
        Long id_usuario,
//        @NotBlank(message = "O campo CPF não pode estar vazio.")
//        @Pattern(
//                regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11})$",
//                message = "O CPF informado é inválido. Utilize o formato 000.000.000-00 ou apenas os 11 dígitos."
//        )
        String cpf,

//        @NotBlank(message = "O campo RG não pode estar vazio.")
//        @Pattern(
//                regexp = "^(\\d{1,2}\\.\\d{3}\\.\\d{3}-?[A-Za-z0-9]{1})$",
//                message = "O RG informado é inválido. Utilize um formato como XX.XXX.XXX-X."
//        )
        String rg) {}
