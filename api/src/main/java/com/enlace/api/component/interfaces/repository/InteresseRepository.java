package com.enlace.api.component.interfaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enlace.api.model.contato.Interesse;

public interface InteresseRepository extends JpaRepository<Interesse, Long>{

}
