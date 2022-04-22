package com.dio.votacao.bbb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.votacao.bbb.model.ParticipanteModel;
import com.dio.votacao.bbb.service.ServiceVotacao;

@RestController
@RequestMapping("/api/votacao")
public class VotacaoController {

	@Autowired
	ServiceVotacao serviceVotacao;
	
	@PostMapping("/votar")
	public ResponseEntity<String> votar(@RequestBody ParticipanteModel model ){
			serviceVotacao.adicionarEvento(model);
		return ResponseEntity.ok("Voto computado com sucesso");
	}
}
