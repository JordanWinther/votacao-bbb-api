package com.dio.votacao.bbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dio.votacao.bbb.model.ParticipanteModel;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String>{

}
