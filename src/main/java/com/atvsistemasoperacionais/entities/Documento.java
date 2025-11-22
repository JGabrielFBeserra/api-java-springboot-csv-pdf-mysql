package com.atvsistemasoperacionais.entities;


import com.atvsistemasoperacionais.DTOs.DocumentoCreateDTO;
import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "Documento")
@Table( name = "documentos")
public class Documento {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    private Long id_usuario;

    private String cpf;
    private String rg;

    public Documento(DocumentoCreateDTO dados) {
        this.id_usuario = dados.id_usuario();
        this.cpf = dados.cpf();
        this.rg = dados.rg();

    }
}




