package br.com.itau.desafio.service;

import br.com.itau.desafio.dto.Categoria;
import br.com.itau.desafio.dto.Lancamento;
import java.util.List;
import java.util.Optional;

public interface FaturaService {

    public List<Lancamento> buscarLancamentos();

    public List<Categoria> buscarCategorias();

    public Optional<Categoria> buscarCategoriaPorId(Long id);

    public Optional<Lancamento> buscarLancamentoPorId(Long id);

    public List<Lancamento> buscarLancamentosPorCategoria(Integer id);

}
