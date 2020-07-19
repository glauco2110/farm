package com.glauco.farm.api.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.glauco.farm.api.response.Response;

public abstract class BaseController<T> implements BaseInterfaceController<T> {

    @PostMapping()
    public ResponseEntity<Response<T>> create(HttpServletRequest request, @RequestBody T objeto, BindingResult result) {
        Response<T> response = new Response<>();
        try {
            validarTransacao(objeto, result);
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            objeto = createOrUpdate(objeto);
            response.setData(objeto);
            return ResponseEntity.ok(response);
        }  catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping()
    public ResponseEntity<Response<T>> update(HttpServletRequest request, @RequestBody T objeto, BindingResult result) {
        Response<T> response = new Response<>();
        try {
            validarTransacao(objeto, result);
            if (result.hasErrors()) {
                result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
                return ResponseEntity.badRequest().body(response);
            }
            objeto = createOrUpdate(objeto);
            response.setData(objeto);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.getErrors().add(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Response<T>> findById(@PathVariable("id") String id) {
        Response<T> response = new Response<T>();
        T objeto = find(id);
        if(Optional.ofNullable(objeto).isPresent()) {
            response.setData(objeto);
            return ResponseEntity.ok(response);
        }
        response.getErrors().add("Register not found id:" + id);
        return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response<String>> delete(@PathVariable("id") String id) {
        Response<String> response = new Response<String>();
        T objeto = find(id);
        if (Optional.ofNullable(objeto).isPresent()) {
            excluirObjeto(objeto);
            return ResponseEntity.ok(new Response<String>());
        }
        response.getErrors().add("Register not found id:" + id);
        return ResponseEntity.badRequest().body(response);
    }

    @GetMapping(value = "{page}/{count}")
    public  ResponseEntity<Response<Page<T>>> findAll(@PathVariable int page, @PathVariable int count) {
        Response<Page<T>> response = new Response<>();
        Page<T> list = listar(page, count);
        response.setData(list);
        return ResponseEntity.ok(response);
    }

}
