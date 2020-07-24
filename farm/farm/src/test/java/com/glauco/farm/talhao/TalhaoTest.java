package com.glauco.farm.talhao;

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
import com.glauco.farm.api.model.Talhao;
import com.glauco.farm.api.services.fazenda.FazendaService;
import com.glauco.farm.api.services.talhao.TalhaoService;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class TalhaoTest {

    private static final Double AREA_TALHAO = 500D;

    private static final Double ESPACAMENTO_TALHAO = 0.45;

    private static final Long PLANTA_POR_METRO_TALHAO = 12L;

    @Autowired
    private FazendaService fazendaService;

    @Autowired
    private TalhaoService talhaoService;

    @Test
    public void testSave() {
        String codTalhao = UUID.randomUUID().toString();
        Talhao talhao = insertTalhao(codTalhao);
        assertNotNull(talhao);
        assertNotNull(talhao.getId());
        assertEquals(codTalhao, talhao.getCodigo());
        assertEquals(AREA_TALHAO, talhao.getArea());
        assertEquals(ESPACAMENTO_TALHAO, talhao.getEspacamentoPorPlanta());
        assertEquals(PLANTA_POR_METRO_TALHAO, talhao.getPlantaPorMetro());
    }

    @Test
    public void testDelete() {
        String codTalhao = UUID.randomUUID().toString();
        Talhao talhao = insertTalhao(codTalhao);
        String id = talhao.getId();
        talhaoService.excluirObjeto(talhao);
        assertNull(talhaoService.find(id));
    }

    private Talhao insertTalhao(String codTalhao) {
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
