package br.com.itau.desafio.service.impl;

import br.com.itau.desafio.dto.Categoria;
import br.com.itau.desafio.dto.Lancamento;
import br.com.itau.desafio.service.CategoriasService;
import br.com.itau.desafio.service.FaturaService;
import br.com.itau.desafio.service.LancamentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("FaturaService")
public class FaturaServiceImp implements FaturaService {

    @Autowired
    private CategoriasService categoriasService;

    @Autowired
    private LancamentosService lancamentosService;

    @Override
    public List<Lancamento> buscarLancamentos(){

        List<Lancamento> lancamentos = lancamentosService.getLancamentos()
                .stream()
                .sorted(Comparator.comparingInt(Lancamento::getMes))
                .collect(Collectors.toList());

        return lancamentos;
    }

    @Override
    public List<Categoria> buscarCategorias(){

        List<Categoria> categorias = categoriasService.getCategorias();
        return categorias;
    }

    @Override
    public Optional<Categoria> buscarCategoriaPorId(Long id){

        Optional<Categoria> categoria = categoriasService.getCategorias()
                .stream()
                .filter(c -> c.getId() == id)
                .findFirst();

        return categoria;
    }

    @Override
    public Optional<Lancamento> buscarLancamentoPorId(Long id){

        Optional<Lancamento> lancamento = lancamentosService.getLancamentos()
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst();

        return lancamento;
    }

    @Override
    public List<Lancamento> buscarLancamentosPorCategoria(Integer id){

        List<Lancamento> lancamentos = lancamentosService.getLancamentos()
                .stream()
                .filter(l -> l.getCategoria() == id)
                .sorted(Comparator.comparingInt(Lancamento::getMes))
                .collect(Collectors.toList());

        return lancamentos;
    }

}
