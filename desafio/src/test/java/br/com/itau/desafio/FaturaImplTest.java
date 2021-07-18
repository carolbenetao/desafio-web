package br.com.itau.desafio;

import br.com.itau.desafio.dto.Lancamento;
import br.com.itau.desafio.service.CategoriasService;
import br.com.itau.desafio.service.FaturaService;
import br.com.itau.desafio.service.LancamentosService;
import br.com.itau.desafio.service.impl.FaturaServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class FaturaImplTest {

    private FaturaService faturaService;

    @Mock
    private LancamentosService lancamentosService;

    @Mock
    private CategoriasService categoriasService;

    @Before
    public void setUp()
    {
        this.faturaService = new FaturaServiceImp();
    }

    @Test
    public void deveRetornarSucesso_QuandoAo_BuscarLancamentos(){
        List<Object[]> objList = new ArrayList<>();
        List<Lancamento> actual = new ArrayList<>();

        List<Lancamento> expected = new ArrayList<>();

        Lancamento dto =  new Lancamento();
        dto.setId(1L);
        dto.setValor(10.0);
        dto.setOrigem("ORIGEM TESTE");
        dto.setCategoria(1);
        dto.setMes(1);

        Object[] obj = new Object[5];
        obj[0] = 1L;
        obj[1] = 10.0;
        obj[2] = "ORIGEM TESTE";
        obj[3] = 1;
        obj[4] = 1;

        objList.add(obj);

        //when(faturaService.buscarLancamentos()).thenReturn(objList);

        actual = faturaService.buscarLancamentos();

        assertEquals(expected , actual);

        verify(faturaService, times(1)).buscarLancamentos();

    }
}
