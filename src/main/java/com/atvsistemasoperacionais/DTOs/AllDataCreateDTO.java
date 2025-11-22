package com.atvsistemasoperacionais.DTOs;

public record AllDataCreateDTO (String nome,
                                String email,
                                String senha,
                                String cpf,
                                String rg,
                                Long id_usuario,
                                String uf,
                                String cidade,
                                String bairro,
                                String numero,
                                String cep,
                                String complemento){
}
