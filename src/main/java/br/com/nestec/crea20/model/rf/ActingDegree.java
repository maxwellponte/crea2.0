package br.com.nestec.crea20.model.rf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Table(name = "grau_autuacao")
public class ActingDegree {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "codigo")
    private String code;
    @Column(name = "descricao")
    private String description;
    @Column(name = "texto")
    private String text;
}
