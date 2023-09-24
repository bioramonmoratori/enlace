package com.enlace.api.component.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlace.api.model.contato.VinculoAfetivo;

public interface VinculoAfetivoRepository extends JpaRepository<VinculoAfetivo, Long>{

}
