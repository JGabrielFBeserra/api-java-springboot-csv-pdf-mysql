package com.atvsistemasoperacionais.DTOs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record EnderecoCreateDTO(
        Long id_usuario,
        String uf,
        String cidade,
        String bairro,
        String numero,
        String cep,
        String complemento

){
}
