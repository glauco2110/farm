package com.glauco.farm.api.dto;

import com.glauco.farm.api.model.Talhao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducaoTalhaoDTO {

    private Talhao talhao;

    private Integer ano;

    private Double total;

}
