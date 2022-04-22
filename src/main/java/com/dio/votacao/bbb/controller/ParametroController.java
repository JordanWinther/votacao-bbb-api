
package com.dio.votacao.bbb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.votacao.bbb.model.ParametroModel;
import com.dio.votacao.bbb.repository.ParametroRepository;

@RestController
@RequestMapping("/api/parametro")
public class ParametroController {
	
	@Autowired
	ParametroRepository parametroRepository;
	
	@GetMapping("/teste")
	public String online() {
		return "online";
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel model ){
		ParametroModel ParametroModel = parametroRepository.save(model);
		return ResponseEntity.ok(ParametroModel);
	}
	
	@GetMapping("/consultar")
	public ResponseEntity<ParametroModel> consulta(@RequestParam String chave){
		Optional<ParametroModel> optionalParametro = parametroRepository.findById(chave);
		if (optionalParametro.isEmpty()) {
			return (ResponseEntity.notFound().build());
		}
		return ResponseEntity.ok(optionalParametro.get());
	}

}
