package com.dio.votacao.bbb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.votacao.bbb.model.ParticipanteModel;
import com.dio.votacao.bbb.repository.ParticipanteRepository;

@RestController
@RequestMapping("/api/participante")
public class ParticipanteController {
	
	
	@Autowired
	ParticipanteRepository participanteRepository;
	
	
	
	@PostMapping("/salvar")
	public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel model ){
		ParticipanteModel participanteModel = participanteRepository.save(model);
		return ResponseEntity.ok(participanteModel);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParticipanteModel> consulta(@RequestParam String nome){
		Optional<ParticipanteModel> optionalParametro = participanteRepository.findById(nome);
		if (optionalParametro.isEmpty()) {
			return (ResponseEntity.notFound().build());
		}
		return ResponseEntity.ok(optionalParametro.get());
	}
	
	@GetMapping("/consultarTodos")
	public ResponseEntity<List<ParticipanteModel>> consultaTodos(){
		List<ParticipanteModel> optionalParticipantes = participanteRepository.findAll();
		return ResponseEntity.ok(optionalParticipantes);
	}

}
