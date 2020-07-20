package com.glauco.farm.api.util;

import java.util.List;

import com.glauco.farm.api.dto.ProducaoTalhaoDTO;

public class CalcularProducaoFazenda {

    public static Double calcularProdutividadeFazenda(List<ProducaoTalhaoDTO> producaoList) {
        Double total = producaoList.stream().map(item->
                item.getTotal()).mapToDouble(Double::doubleValue).sum();

        return total;
    }

}
