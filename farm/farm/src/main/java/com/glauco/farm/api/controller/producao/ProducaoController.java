package com.glauco.farm.api.controller.producao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glauco.farm.api.controller.BaseController;
import com.glauco.farm.api.model.Producao;
import com.glauco.farm.api.response.Response;
import com.glauco.farm.api.services.producao.ProducaoService;

@RestController
@RequestMapping("/api/producao")
@CrossOrigin(origins = "*")
public class ProducaoController extends BaseController<Producao> {

    @Autowired
    private ProducaoService producaoService;

    @Override
    public Producao createOrUpdate(Producao objeto) {
        return producaoService.createOrUpdate(objeto);
    }

    @Override
    public Producao find(String id) {
        return producaoService.find(id);
    }

    @Override
    public void excluirObjeto(Producao objeto) {
        producaoService.excluirObjeto(objeto);
    }

    @Override
    public void validarTransacao(Producao objeto, BindingResult result) {

    }

    @Override
    public Page<Producao> listar(int page, int count) {
        return producaoService.findAll(page, count);
    }

    @GetMapping(value = "/{page}/{count}/{talhaoId}")
    public ResponseEntity<Response<Page<Producao>>> findByTalhaoId(@PathVariable int page, @PathVariable int count, @PathVariable String talhaoId) {
        Response<Page<Producao>> response = new Response<>();
        Page<Producao> list = this.producaoService.findByTalhaoId(page, count, talhaoId);
        response.setData(list);
        return ResponseEntity.ok(response);
    }
}
