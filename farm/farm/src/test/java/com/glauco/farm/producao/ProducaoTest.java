package com.glauco.farm.producao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.glauco.farm.api.model.Fazenda;
import com.glauco.farm.api.model.Producao;
import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.services.fazenda.FazendaService;
import com.glauco.farm.api.services.producao.ProducaoService;
import com.glauco.farm.api.services.talhao.TalhaoService;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ProducaoTest {

    private static final Double AREA_TALHAO = 500D;

    private static final Double ESPACAMENTO_TALHAO = 0.45;

    private static final Long PLANTA_POR_METRO_TALHAO = 12L;

    private static final Integer ANO_PRODUCAO = 2019;

    private static final Double GRAMAS_A_CADA_CEM = 0.25;

    private static final Integer GRAOS_POR_VAGEM  = 2;

    private static final Integer VAGEM_POR_PLANTA = 2;

    @Autowired
    private FazendaService fazendaService;

    @Autowired
    private TalhaoService talhaoService;

    @Autowired
    private ProducaoService producaoService;

    @Test
    public void testSave() {
        Producao producao = insertProducao();

        assertNotNull(producao);
        assertNotNull(producao.getId());
        assertEquals(ANO_PRODUCAO, producao.getAno());
        assertEquals(GRAMAS_A_CADA_CEM, producao.getGramasACadaCem());
        assertEquals(GRAOS_POR_VAGEM, producao.getGraosPorVagen());
        assertEquals(VAGEM_POR_PLANTA, producao.getVagensPorPlanta());
    }

    @Test
    public void testDelete() {
        Producao producao = insertProducao();
        String id = producao.getId();
        producaoService.excluirObjeto(producao);
        assertNull(producaoService.find(id));
    }

    private Producao insertProducao() {
        return producaoService.createOrUpdate(getProducao());
    }

    private Producao getProducao() {
        Talhao talhao = insertTalhao();
        Producao producao = new Producao();
        producao.setTalhao(talhao);
        producao.setAno(ANO_PRODUCAO);
        producao.setGramasACadaCem(GRAMAS_A_CADA_CEM);
        producao.setGraosPorVagen(GRAOS_POR_VAGEM);
        producao.setVagensPorPlanta(VAGEM_POR_PLANTA);

        return producao;
    }

    private Talhao insertTalhao() {
        String codTalhao = UUID.randomUUID().toString();
        return talhaoService.createOrUpdate(getTalhao(codTalhao));
    }

    private Talhao getTalhao(String codTalhao) {

        String nome = UUID.randomUUID().toString();
        Fazenda fazenda = insertFazenda(nome);

        Talhao talhao = new Talhao();
        talhao.setCodigo(codTalhao);
        talhao.setArea(AREA_TALHAO);
        talhao.setEspacamentoPorPlanta(ESPACAMENTO_TALHAO);
        talhao.setPlantaPorMetro(PLANTA_POR_METRO_TALHAO);
        talhao.setFazenda(fazenda);

        return talhao;
    }

    private Fazenda getFazenda(String nome) {
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(nome);
        return fazenda;
    }

    private Fazenda insertFazenda(String nome) {
        return fazendaService.createOrUpdate(getFazenda(nome));
    }
}
