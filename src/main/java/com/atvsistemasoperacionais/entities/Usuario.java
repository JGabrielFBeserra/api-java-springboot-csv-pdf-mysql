package com.atvsistemasoperacionais.entities;


import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "Usuario")
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(UsuarioCreateDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();

    }
}
