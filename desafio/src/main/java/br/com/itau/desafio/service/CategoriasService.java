package br.com.itau.desafio.service;

import br.com.itau.desafio.dto.Categoria;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "https://desafio-it-server.herokuapp.com/categorias" , name = "categorias")
public interface CategoriasService {

    @GetMapping()
    List<Categoria> getCategorias();
}
