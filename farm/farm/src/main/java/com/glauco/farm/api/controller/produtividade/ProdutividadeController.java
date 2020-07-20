package com.glauco.farm.api.controller.produtividade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glauco.farm.api.dto.ProducaoFazendaDTO;
import com.glauco.farm.api.dto.ProducaoTalhaoDTO;
import com.glauco.farm.api.model.Fazenda;
import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.response.Response;
import com.glauco.farm.api.services.fazenda.FazendaService;
import com.glauco.farm.api.services.producao.ProducaoService;
import com.glauco.farm.api.services.talhao.TalhaoService;
import com.glauco.farm.api.util.CalcularProducaoFazenda;
import com.glauco.farm.api.util.CalcularProducaoTalhao;

@RestController
@RequestMapping("/api/produtividade-consultar")
@CrossOrigin(origins = "*")
public class ProdutividadeController {

    @Autowired
    private FazendaService fazendaService;

    @Autowired
    private TalhaoService talhaoService;

    @Autowired
    private ProducaoService producaoService;

    @GetMapping(value = "{id}/{ano}")
    public ResponseEntity<Response<ProducaoFazendaDTO>> findById(@PathVariable("id") String id, @PathVariable("ano") Integer ano) {
        Response<ProducaoFazendaDTO> response = new Response<>();

        Fazenda fazenda = this.fazendaService.find(id);

        ProducaoFazendaDTO producao = new ProducaoFazendaDTO();
        producao.setFazenda(fazenda);
        producao.setAno(ano);
        producao.setProducaoTalhaoDTOList(getProducaoTalhoesFazenda(fazenda, ano));
        producao.setValor(CalcularProducaoFazenda.calcularProdutividadeFazenda(producao.getProducaoTalhaoDTOList()));

        response.setData(producao);

        return ResponseEntity.ok(response);
    }


    private List<ProducaoTalhaoDTO> getProducaoTalhoesFazenda(Fazenda fazenda, Integer ano) {
        List<Talhao> talhoes = talhaoService.findAllByFazendaId(fazenda.getId());
        List<ProducaoTalhaoDTO> producaoList = new ArrayList<>();
        if(Optional.ofNullable(talhoes).isPresent()) {
            talhoes.forEach(talhao -> {
                ProducaoTalhaoDTO dto = new ProducaoTalhaoDTO();
                CalcularProducaoTalhao calcular = new CalcularProducaoTalhao();
                calcular.setProducaoService(producaoService);
                calcular.setTalhao(talhao);
                Double valor = calcular.calcularPorAno(ano);

                if(Optional.ofNullable(valor).isPresent()) {
                    dto.setTalhao(talhao);
                    dto.setAno(ano);
                    dto.setTotal(calcular.calcularPorAno(ano));

                    producaoList.add(dto);
                }

            });
        }

        return producaoList;
    }

}
