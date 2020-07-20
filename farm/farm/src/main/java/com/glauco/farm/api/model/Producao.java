package com.glauco.farm.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Producao {

    @Id
    private String id;

    private Integer ano;

    private Double vagensPorPlanta;

    private Integer graosPorVagen;

    private Double gramasACadaCem;

    @DBRef(lazy = true)
    private Talhao talhao;

}
