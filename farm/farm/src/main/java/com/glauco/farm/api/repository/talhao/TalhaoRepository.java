package com.glauco.farm.api.repository.talhao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.glauco.farm.api.model.Talhao;

public interface TalhaoRepository extends MongoRepository<Talhao, String> {

    Page<Talhao> findByFazendaId(Pageable pages, String fazendaId);

    List<Talhao> findAllByFazendaId(String fazendaId);
}
