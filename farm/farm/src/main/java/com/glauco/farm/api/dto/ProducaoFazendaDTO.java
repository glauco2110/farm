package com.glauco.farm.api.dto;

import java.util.List;

import com.glauco.farm.api.model.Fazenda;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProducaoFazendaDTO {

    private Fazenda fazenda;

    private Integer ano;

    private Double valor;

    private List<ProducaoTalhaoDTO> producaoTalhaoDTOList;

}
