package com.dio.votacao.bbb.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.dio.votacao.bbb.model.ParticipanteModel;

@Service
public class ServiceVotacao {

	private static final String  VOTACAO_OPICO = "votacao";
	
	private final KafkaTemplate<Object, Object> template;
	
	public ServiceVotacao(KafkaTemplate<Object, Object> template ) {
		this.template = template;

	}
	
	
	public void adicionarEvento(ParticipanteModel participanteModel) {
		template.send(VOTACAO_OPICO, participanteModel);
	}
}
