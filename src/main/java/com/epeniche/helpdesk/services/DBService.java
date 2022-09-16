package com.epeniche.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.epeniche.helpdesk.domain.Chamado;
import com.epeniche.helpdesk.domain.Cliente;
import com.epeniche.helpdesk.domain.Tecnico;
import com.epeniche.helpdesk.domain.enums.Perfil;
import com.epeniche.helpdesk.domain.enums.Prioridade;
import com.epeniche.helpdesk.domain.enums.Status;
import com.epeniche.helpdesk.repositories.ChamadoRepository;
import com.epeniche.helpdesk.repositories.ClienteRepository;
import com.epeniche.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "10947364064", "valdir@email.com", encoder.encode("senha1"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Eduardo", "14280807752", "eduardo@email.com", encoder.encode("senha1"));
		Tecnico tec3 = new Tecnico(null, "Filipe", "99514371097", "filipe@email.com", encoder.encode("senha1"));
		Tecnico tec4 = new Tecnico(null, "Fabio", "96337234006", "fabio@email.com", encoder.encode("senha1"));
		
		Cliente cli1 = new Cliente(null, "Linus", "98183633021", "linus@email.com", encoder.encode("senha2"));
		Cliente cli2 = new Cliente(null, "Bill", "24756230040", "bill@email.com", encoder.encode("senha2"));
		Cliente cli3 = new Cliente(null, "Bob", "76196118005", "bob@email.com", encoder.encode("senha2"));
		Cliente cli4 = new Cliente(null, "Jorge", "64010306076", "jorge@email.com", encoder.encode("senha2"));
	
		
		Chamado chamado1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		Chamado chamado2 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado 02", "Primeiro chamado", tec2, cli3);
		Chamado chamado3 = new Chamado(null, Prioridade.ALTA, Status.ENCERRADO, "Chamado 03", "Primeiro chamado", tec3, cli4);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
		chamadoRepository.saveAll(Arrays.asList(chamado1,chamado2,chamado3));
	}
	
}
