package br.com.nestec.crea20.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Getter @NoArgsConstructor
public enum Gender {
    MASCULINO("Masculino"), FEMININO("Feminino");
    private String description;
}
