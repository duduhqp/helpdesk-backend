package com.epeniche.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epeniche.helpdesk.domain.Chamado;
import com.epeniche.helpdesk.domain.Cliente;
import com.epeniche.helpdesk.domain.Tecnico;
import com.epeniche.helpdesk.domain.enums.Perfil;
import com.epeniche.helpdesk.domain.enums.Prioridade;
import com.epeniche.helpdesk.domain.enums.Status;
import com.epeniche.helpdesk.repositories.ChamadoRepository;
import com.epeniche.helpdesk.repositories.ClienteRepository;
import com.epeniche.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner{
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "14280807752", "valdir@email.com", "senha1");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus", "743.225.880-50", "linus@email.com", "senha2");
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);         
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(chamado1));
	}

}
