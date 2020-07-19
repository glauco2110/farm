package com.glauco.farm.api.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Fazenda {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "Nome é de preenchimento obrigatorio")
    private String nome;
}
