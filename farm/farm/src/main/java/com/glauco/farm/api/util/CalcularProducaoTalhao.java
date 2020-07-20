package com.glauco.farm.api.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.glauco.farm.api.model.Producao;
import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.services.producao.ProducaoService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalcularProducaoTalhao {

    private ProducaoService producaoService;

    private final Integer UMA_TONELADA = 1000;
    
    private Talhao talhao;
    
    private Integer ano;
    
    public Double calcularPorAno(Integer ano) {
        Producao producao = getProducaoAno(ano);

        if(Optional.ofNullable(producao).isPresent()) {
            return (calcularPlantasPorTalhao() * (producao.getVagensPorPlanta() * producao.getGraosPorVagen()) * producao.getGramasACadaCem()) / UMA_TONELADA;
        }

        return null;
    }

    private Producao getProducaoAno(Integer ano) {
        return this.producaoService.findByTalhaoIdAno(talhao.getId(), ano);
    }

    private Double calcularPlantasPorTalhao() {
        return (talhao.getPlantaPorMetro() / talhao.getEspacamentoPorPlanta()) * talhao.getArea();
    }
}
