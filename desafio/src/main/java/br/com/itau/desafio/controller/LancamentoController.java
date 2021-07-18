package br.com.itau.desafio.controller;

import br.com.itau.desafio.dto.Categoria;
import br.com.itau.desafio.dto.Lancamento;
import br.com.itau.desafio.service.CategoriasService;
import br.com.itau.desafio.service.impl.FaturaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import br.com.itau.desafio.service.LancamentosService;
import java.util.List;
import java.util.Optional;

@RestController
public class LancamentoController {

    @Autowired
    private FaturaServiceImp faturaServiceImp;

    @GetMapping("lancamentos")
    public ResponseEntity getLancamentos(){

        List<Lancamento> lancamentos = faturaServiceImp.buscarLancamentos();

        return lancamentos != null ? ResponseEntity.ok().body(lancamentos) : ResponseEntity.notFound().build();
    }

    @GetMapping("categorias")
    public ResponseEntity getCategorias(){

        List<Categoria> categorias = faturaServiceImp.buscarCategorias();
        return categorias != null ? ResponseEntity.ok().body(categorias) : ResponseEntity.notFound().build();
    }

    @GetMapping("categoria/{id}")
    public ResponseEntity getCategoriaById(@PathVariable Long id){

        Optional<Categoria> categoria = faturaServiceImp.buscarCategoriaPorId(id);

        return categoria != null ? ResponseEntity.ok().body(categoria) : ResponseEntity.notFound().build();
    }

    @GetMapping("lancamento/{id}")
    public ResponseEntity getLancamentoById(@PathVariable Long id){

        Optional<Lancamento> lancamento = faturaServiceImp.buscarLancamentoPorId(id);

        return lancamento != null ? ResponseEntity.ok().body(lancamento) : ResponseEntity.notFound().build();
    }

    @GetMapping("lancamento-categoria/{id}")
    public ResponseEntity getLancamentoByCategoria(@PathVariable Integer id){

        List<Lancamento> lancamentos = faturaServiceImp.buscarLancamentosPorCategoria(id);

        return lancamentos != null ? ResponseEntity.ok().body(lancamentos) : ResponseEntity.notFound().build();

    }
}
