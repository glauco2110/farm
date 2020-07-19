package com.glauco.farm.api.services;

import org.springframework.data.domain.Page;

public interface BaseService<T> {

    T createOrUpdate(T objeto);
    void excluirObjeto(T objeto);
    T find(String id);
    Page<T> findAll(int page, int count);
}
