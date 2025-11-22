package com.atvsistemasoperacionais.Services;


import com.atvsistemasoperacionais.DTOs.AllDataCreateDTO;
import com.atvsistemasoperacionais.DTOs.DocumentoCreateDTO;
import com.atvsistemasoperacionais.DTOs.EnderecoCreateDTO;
import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import com.atvsistemasoperacionais.entities.Documento;
import com.atvsistemasoperacionais.entities.Endereco;
import com.atvsistemasoperacionais.entities.Usuario;
import com.atvsistemasoperacionais.repositorys.DocumentoRepository;
import com.atvsistemasoperacionais.repositorys.EnderecoRepository;
import com.atvsistemasoperacionais.repositorys.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository Usuariorepository;

    @Autowired
    private DocumentoRepository DocumentoRepository;

    @Autowired
    private EnderecoRepository EnderecoRepository;

    @Transactional
    public Boolean cadastrarUsuario(AllDataCreateDTO dados) {
        var usuario = new Usuario(new UsuarioCreateDTO(dados.nome(), dados.email(), dados.senha()));
        Usuariorepository.save(usuario);
        var documento = new Documento(new DocumentoCreateDTO(usuario.getId(), dados.cpf(), dados.rg()));
        DocumentoRepository.save(documento);
        System.out.println(dados.uf());
        var endereco = new Endereco(new EnderecoCreateDTO(usuario.getId(), dados.cep(), dados.uf(), dados.cidade(), dados.bairro(), dados.numero(), dados.complemento()));

        EnderecoRepository.save(endereco);
        return true;
    }
}
