package br.com.nestec.crea20.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum StatusRoute {
    AF("A Fazer"), AFA("A fazer (Atrasado)"), C("Concluído");

    private String descricao;
}
