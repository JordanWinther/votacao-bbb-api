package com.dio.votacao.bbb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dio.votacao.bbb.model.ParametroModel;

public interface ParametroRepository extends MongoRepository<ParametroModel, String> {

}
