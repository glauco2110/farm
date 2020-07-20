package com.glauco.farm.api.services.talhao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.repository.talhao.TalhaoRepository;
import com.glauco.farm.api.services.talhao.TalhaoService;

@Component
public class TalhaoServiceImpl implements TalhaoService {

    @Autowired
    private TalhaoRepository talhaoRepository;

    @Override
    public Talhao createOrUpdate(Talhao talhao) {
        return this.talhaoRepository.save(talhao);
    }

    @Override
    public void excluirObjeto(Talhao talhao) {
        this.talhaoRepository.delete(talhao);
    }

    @Override
    public Talhao find(String id) {
        return this.talhaoRepository.findOne(id);
    }

    @Override
    public Page<Talhao> findAll(int page, int count) {
        Pageable pages = new PageRequest(page, count);
        return this.talhaoRepository.findAll(pages);
    }

    @Override
    public Page<Talhao> findByFazendaId(int page, int count, String fazendaId) {
        Pageable pages = new PageRequest(page, count);
        return this.talhaoRepository.findByFazendaId(pages, fazendaId);
    }

    @Override
    public List<Talhao> findAllByFazendaId(String fazendaId) {
        return this.talhaoRepository.findAllByFazendaId(fazendaId);
    }
}
