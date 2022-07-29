package com.epeniche.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epeniche.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{

}
