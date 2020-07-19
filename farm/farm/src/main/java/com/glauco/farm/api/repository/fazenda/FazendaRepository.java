package com.glauco.farm.api.repository.fazenda;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glauco.farm.api.model.Fazenda;

public interface FazendaRepository extends MongoRepository<Fazenda, String> {


}
