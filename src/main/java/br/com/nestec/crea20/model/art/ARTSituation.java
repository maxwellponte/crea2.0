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
public class ARTSituation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "situacao")
    private String situation;
    @Column(name = "descricao")
    private String description;
    @Column(name = "data")
    private String date;
    @Column(name = "hora")
    private String hour;
}
