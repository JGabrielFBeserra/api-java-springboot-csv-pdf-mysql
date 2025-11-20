package com.atvsistemasoperacionais.Services;


import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import com.atvsistemasoperacionais.entities.Usuario;
import com.atvsistemasoperacionais.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrarUsuario(UsuarioCreateDTO dados) {
        var usuario = new Usuario(dados);

        return usuario;
    }
}
