package com.atvsistemasoperacionais.repositorys;

import com.atvsistemasoperacionais.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
}
