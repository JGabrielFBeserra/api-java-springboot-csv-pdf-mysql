package com.atvsistemasoperacionais.controllers;

import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import com.atvsistemasoperacionais.Services.UsuarioService;
import com.atvsistemasoperacionais.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> cadastarUsuario(@RequestBody @Valid UsuarioCreateDTO dados) {
        var usuario = service.cadastrarUsuario(dados);

        return ResponseEntity.ok(usuario);

    }
}
