package com.atvsistemasoperacionais.Services;

import com.atvsistemasoperacionais.DTOs.DocumentoCreateDTO;
import com.atvsistemasoperacionais.DTOs.UsuarioCreateDTO;
import com.atvsistemasoperacionais.entities.Documento;
import com.atvsistemasoperacionais.entities.Usuario;
import com.atvsistemasoperacionais.repositorys.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    @Transactional
    public Documento cadastrarDocumento(DocumentoCreateDTO dados) {

        var documento = new Documento(dados);
        System.out.println(documento.getId_usuario());
        System.out.println(documento.getCpf());
        System.out.println(documento.getRg());

        repository.save(documento);
        return documento;
    }
}
