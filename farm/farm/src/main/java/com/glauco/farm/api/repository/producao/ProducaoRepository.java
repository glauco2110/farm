package com.glauco.farm.api.repository.producao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.glauco.farm.api.model.Producao;

public interface ProducaoRepository extends MongoRepository<Producao, String> {

    Page<Producao> findByTalhaoId(Pageable pages, String talhaoId);

}
