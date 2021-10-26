package br.com.nestec.crea20.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum UF {
    RO("Rondônia"), AC("Acre"), AM("Amazonas"), RR("Roraima"), PA("Pará"), AP("Amapá"), TO("Tocantins"), MA("Maranhão"),
    PI("Piauí"), CE("Ceará"), RN("Rio Grande do Norte"), PB("Paraiba"), PE("Pernambuco"), AL("Alagoas"), SE("Sergipe"),
    BA("Bahia"), MG("Minas Gerais"), ES("Espírito Santo"), RJ("Rio de Janeiro"), SP("São Paulo"), PR("Paraná"),
    SC("Santa Catarina"), RS("Rio Grande do Sul"), MS("Mato Grosso do Sul"), MT("Mato Grosso"), GO("Goiás"),
    DF("Distrito Federal");

    private String description;
}
