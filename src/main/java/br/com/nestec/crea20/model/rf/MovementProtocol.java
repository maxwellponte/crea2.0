package br.com.nestec.crea20.model.rf;

import br.com.nestec.crea20.model.rf.IRAutoProcedures;

import javax.persistence.*;

@Entity
@Table(name = "protocolo_movimento")
public class MovementProtocol {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    @Column(name = "setor_destino")
    private String destinationSector;
    @Column(name = "usuario_destino")
    private String destinationUser;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tramite_auto_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tramite_auto"))
    private IRAutoProcedures autoProcedures;
}
