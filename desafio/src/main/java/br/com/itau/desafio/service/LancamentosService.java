package br.com.itau.desafio.service;

import br.com.itau.desafio.dto.Lancamento;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "https://desafio-it-server.herokuapp.com/lancamentos" , name = "lancamentos")
public interface LancamentosService {

    @GetMapping()
    List<Lancamento> getLancamentos();
}
