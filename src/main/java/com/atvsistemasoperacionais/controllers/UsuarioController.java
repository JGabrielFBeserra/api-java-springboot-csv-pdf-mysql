package com.atvsistemasoperacionais.controllers;

import com.atvsistemasoperacionais.DTOs.AllDataCreateDTO;
import com.atvsistemasoperacionais.Services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService serviceUsuario;




    @PostMapping
    public void cadastarUsuario(@RequestBody @Valid AllDataCreateDTO dados) {
        var usuario = serviceUsuario.cadastrarUsuario(dados);
        System.out.println("Sucesso");



    }
}
