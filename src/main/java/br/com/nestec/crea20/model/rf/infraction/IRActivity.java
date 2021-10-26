package br.com.nestec.crea20.model.rf.infraction;

import br.com.nestec.crea20.model.rf.infraction.IRInfraction;
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
@Table(name = "rf_atividade")
public class IRActivity {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(name = "nivel")
    private String level;
    @Column(name = "atividade_profissional")
    private String professionalActivity;
    @Column(name = "atividade")
    private String activity;
    @Column(name = "unidade_medida")
    private String unitMeasurement;
    @Column(name = "quantidade")
    private String quantity;
    @Column(name = "observacao")
    private String obs;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "infracao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private IRInfraction infraction;
}
