package br.com.nestec.crea20.model.rf.infraction;

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
@Table(name = "infracao")
public class Infraction {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(name = "codigo")
    private String code;
    @Column(name = "descricao")
    private String description;
    @Column(name = "texto")
    private String text;
    @Column(name = "valor_minimo")
    private double minValue;
    @Column(name = "valor_maximo")
    private double maxValue;
}
