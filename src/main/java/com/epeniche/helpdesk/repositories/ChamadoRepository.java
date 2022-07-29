package com.epeniche.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.epeniche.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{

}
