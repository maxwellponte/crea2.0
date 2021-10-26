package br.com.nestec.crea20.model.rf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rf_tramite_auto")
public class IRAutoProcedures {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descricao")
    private String description;
    @Column(name = "data_tramite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTramite;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "protocolo_movimento_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_protocolo_movimento"))
    private MovementProtocol movementProtocol;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relatorio_fiscalizacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private InspectionReport inspectionReport;
}