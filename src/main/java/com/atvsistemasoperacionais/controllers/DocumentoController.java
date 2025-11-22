package com.atvsistemasoperacionais.controllers;

import com.atvsistemasoperacionais.DTOs.DocumentoCreateDTO;
import com.atvsistemasoperacionais.Services.DocumentoService;
import com.atvsistemasoperacionais.entities.Documento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.Document;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService service;

    @PostMapping
    public ResponseEntity<Documento> cadastrarDocumento(@RequestBody @Valid DocumentoCreateDTO dados) {
        System.out.println(dados);
        var documento = service.cadastrarDocumento(dados);
        return ResponseEntity.ok(documento);
    }
}
