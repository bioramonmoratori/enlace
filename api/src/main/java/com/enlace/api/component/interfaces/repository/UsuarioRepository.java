package com.enlace.api.component.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlace.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
