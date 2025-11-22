package com.atvsistemasoperacionais.entities;

import com.atvsistemasoperacionais.DTOs.EnderecoCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "enderecos")
@Entity(name = "Endereco")
public class Endereco {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_usuario;

    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String numero;
    private String complemento;

    public Endereco(EnderecoCreateDTO dados) {
        this.id_usuario = dados.id_usuario();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }
}
