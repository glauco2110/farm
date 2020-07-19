package com.glauco.farm.api.controller.fazenda;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glauco.farm.api.controller.BaseController;
import com.glauco.farm.api.model.Fazenda;
import com.glauco.farm.api.services.fazenda.FazendaService;

@RestController
@RequestMapping("/api/fazenda")
@CrossOrigin(origins = "*")
public class FazendaController extends BaseController<Fazenda> {

    @Autowired
    private FazendaService fazendaService;

    @Override
    public Fazenda createOrUpdate(Fazenda fazenda) {
        return this.fazendaService.createOrUpdate(fazenda);
    }

    @Override
    public Fazenda find(String id) {
        return this.fazendaService.find(id);
    }

    @Override
    public void excluirObjeto(Fazenda objeto) {
        this.fazendaService.excluirObjeto(objeto);
    }

    @Override
    public void validarTransacao(Fazenda objeto, BindingResult result) {

    }

    @Override
    public Page<Fazenda> listar(int page, int count) {
        return this.fazendaService.findAll(page, count);
    }
}
