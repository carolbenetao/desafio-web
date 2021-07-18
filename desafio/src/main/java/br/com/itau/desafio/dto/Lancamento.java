package br.com.itau.desafio.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lancamento {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("valor")
    private Double valor;

    @JsonProperty("origem")
    private String origem;

    @JsonProperty("categoria")
    private Integer categoria;

    @JsonProperty("mes_lancamento")
    private Integer mes;

       /* public static List<Lancamento> convertToDto(List<Object[]> obj) {
        List<Lancamento> dtoList = new ArrayList<>();
        for(Object[] o : obj) {
            Lancamento dto = new Lancamento();
            dto.setId(o[0]);
            dto.setValor(o[1]);
            dto.setOrigem(o[2]);
            dto.setCategoria(o[3]);
            dto.setMes(o[4]);

            dtoList.add(dto);
        }
        return dtoList;
    } */

    @Override
    public String toString() {
        return "Lancamento [id=" + id + ", valor=" + valor + ", origem=" + origem + ", categoria=" + categoria
                + ", mes=" + mes + "]";
    }

}
