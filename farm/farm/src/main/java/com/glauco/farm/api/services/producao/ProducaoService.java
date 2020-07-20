package com.glauco.farm.api.services.producao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.glauco.farm.api.model.Producao;
import com.glauco.farm.api.services.BaseService;

@Component
public interface ProducaoService extends BaseService<Producao> {

    Page<Producao> findByTalhaoId(int page, int count, String talhaoId);

    Producao findByTalhaoIdAno(String id, Integer ano);

}
