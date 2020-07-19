package com.glauco.farm.api.services.talhao;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.services.BaseService;

@Component
public interface TalhaoService extends BaseService<Talhao> {

    Page<Talhao> findByFazendaId(int page, int count, String fazendaId);
}
