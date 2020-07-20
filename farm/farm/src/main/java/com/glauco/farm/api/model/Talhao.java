package com.glauco.farm.api.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Talhao {

    @Id
    private String id;

    @Indexed(unique = true)
    @Size(max = 5)
    @NotBlank(message = "Codigo é de preenchimento obrigatorio")
    private String codigo;

    @NotBlank(message = "Area é de preenchimento obrigatorio")
    private Double area;

    @NotBlank(message = "Planta por metro é de preenchimento obrigatorio")
    private Long plantaPorMetro;

    @NotBlank(message = "Espaçamento por planta é de preenchimento obrigatorio")
    private Double espacamentoPorPlanta;

    @DBRef(lazy = true)
    private Fazenda fazenda;
}
