package com.glauco.farm.api.controller.talhao;

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
import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.response.Response;
import com.glauco.farm.api.services.talhao.TalhaoService;

@RestController
@RequestMapping("/api/talhao")
@CrossOrigin(origins = "*")
public class TalhaoController extends BaseController<Talhao> {

    @Autowired
    private TalhaoService talhaoService;

    @Override
    public Talhao createOrUpdate(Talhao talhao) {
        return this.talhaoService.createOrUpdate(talhao);
    }

    @Override
    public Talhao find(String id) {
        return this.talhaoService.find(id);
    }

    @Override
    public void excluirObjeto(Talhao talhao) {
        this.talhaoService.excluirObjeto(talhao);
    }

    @Override
    public void validarTransacao(Talhao objeto, BindingResult result) {

    }

    @Override
    public Page<Talhao> listar(int page, int count) {
        return this.talhaoService.findAll(page, count);
    }

    @GetMapping(value = "/{page}/{count}/{fazendaId}")
    public ResponseEntity<Response<Page<Talhao>>> findByFazendaId(@PathVariable int page, @PathVariable int count, @PathVariable String fazendaId) {
        Response<Page<Talhao>> response = new Response<>();
        Page<Talhao> list = this.talhaoService.findByFazendaId(page, count, fazendaId);
        response.setData(list);
        return ResponseEntity.ok(response);
    }
}
