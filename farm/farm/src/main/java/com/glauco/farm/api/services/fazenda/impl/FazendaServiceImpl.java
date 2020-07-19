package com.glauco.farm.api.services.fazenda.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.glauco.farm.api.model.Fazenda;
import com.glauco.farm.api.repository.fazenda.FazendaRepository;
import com.glauco.farm.api.services.fazenda.FazendaService;

@Component
public class FazendaServiceImpl implements FazendaService {

    @Autowired
    private FazendaRepository fazendaRepository;

    @Override
    public Fazenda createOrUpdate(Fazenda fazenda) { return this.fazendaRepository.save(fazenda); }

    @Override
    public void excluirObjeto(Fazenda fazenda) {
        this.fazendaRepository.delete(fazenda);
    }

    @Override
    public Fazenda find(String id) {
        return this.fazendaRepository.findOne(id);
    }

    @Override
    public Page<Fazenda> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return this.fazendaRepository.findAll(pages);
    }

}
