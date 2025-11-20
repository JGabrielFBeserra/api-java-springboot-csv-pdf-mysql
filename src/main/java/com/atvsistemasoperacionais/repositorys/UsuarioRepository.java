package com.atvsistemasoperacionais.repositorys;

import com.atvsistemasoperacionais.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
