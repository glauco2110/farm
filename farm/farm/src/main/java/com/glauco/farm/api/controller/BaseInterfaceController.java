package com.glauco.farm.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;

import com.glauco.farm.api.response.Response;

public interface BaseInterfaceController<T> {

    T createOrUpdate(T objeto);

    T find(String id);

    void excluirObjeto(T objeto);

    void validarTransacao(T objeto, BindingResult result);

    Page<T> listar(int page, int count);


}
