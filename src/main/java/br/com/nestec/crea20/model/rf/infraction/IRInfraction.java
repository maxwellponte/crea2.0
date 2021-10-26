package br.com.nestec.crea20.model.rf.infraction;

import br.com.nestec.crea20.model.rf.InspectionReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rf_infracao")
public class IRInfraction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descricao")
    private String description;
    @Column(name = "valor")
    private Double value;
    @Column(name = "observacao")
    private String obs;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "infracao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fK_infracao"))
    private Infraction infraction;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "infraction", targetEntity = IRActivity.class)
    @Fetch(FetchMode.JOIN)
    private List<IRActivity> atividades;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relatorio_fiscalizacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private InspectionReport inspectionReport;
}
