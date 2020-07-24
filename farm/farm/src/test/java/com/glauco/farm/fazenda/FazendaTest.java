package com.glauco.farm.fazenda;

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
import com.glauco.farm.api.services.fazenda.FazendaService;

@SpringBootTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class FazendaTest {

    @Autowired
    private FazendaService fazendaService;


    @Test
    public void testSave() {
        String nome = UUID.randomUUID().toString();
        Fazenda fazenda = insertFazenda(nome);
        assertNotNull(fazenda);
        assertNotNull(fazenda.getId());
        assertEquals(nome, fazenda.getNome());
    }

    @Test
    public void testDelete() {
        String nome = UUID.randomUUID().toString();
        Fazenda fazenda = insertFazenda(nome);

        String id = fazenda.getId();
        fazendaService.excluirObjeto(fazenda);
        Fazenda fazendaExcluida = fazendaService.find(id);
        assertNull(fazendaExcluida);
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
