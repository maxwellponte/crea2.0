package br.com.nestec.crea20.model.art;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ARTActivity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nivel")
    private String level;
    @Column(name = "atividade_subordinada")
    private String subordinateActivity;
    @Column(name = "atividade_servico")
    private String serviceActivity;
    @Column(name = "quantidade")
    private String quantity;
    @Column(name = "unidade_medida")
    private String unitMeasurement;
}
