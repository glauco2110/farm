package com.glauco.farm.api.services.producao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.glauco.farm.api.model.Producao;
import com.glauco.farm.api.repository.producao.ProducaoRepository;
import com.glauco.farm.api.services.producao.ProducaoService;

@Component
public class ProducaoServiceImpl implements ProducaoService {

    @Autowired
    private ProducaoRepository producaoRepository;

    @Override
    public Page<Producao> findByTalhaoId(int page, int count, String talhaoId) {
        Pageable pages = new PageRequest(page, count);
        return this.producaoRepository.findByTalhaoId(pages, talhaoId);
    }

    @Override
    public Producao findByTalhaoIdAno(String talhaoId, Integer ano) {
        return this.producaoRepository.findByTalhaoIdAndAno(talhaoId, ano);
    }

    @Override
    public Producao createOrUpdate(Producao objeto) {
        return this.producaoRepository.save(objeto);
    }

    @Override
    public void excluirObjeto(Producao objeto) {
        this.producaoRepository.delete(objeto);
    }

    @Override
    public Producao find(String id) {
        return this.producaoRepository.findOne(id);
    }

    @Override
    public Page<Producao> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return this.producaoRepository.findAll(pages);
    }
}
