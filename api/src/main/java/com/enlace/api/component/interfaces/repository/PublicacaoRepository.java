package com.enlace.api.component.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlace.api.model.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Long>{

}
