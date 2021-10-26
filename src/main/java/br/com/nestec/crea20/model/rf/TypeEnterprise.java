package br.com.nestec.crea20.model.rf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "tipo_empreendimento")
public class TypeEnterprise {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "codigo")
    private String code;
    @Column(name = "descricao")
    private String description;
    @Column(name = "sitac_id")
    private Integer sitacId;
}
