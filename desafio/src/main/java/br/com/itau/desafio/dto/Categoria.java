package br.com.itau.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Categoria {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

}
