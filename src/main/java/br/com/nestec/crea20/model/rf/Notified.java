package br.com.nestec.crea20.model.rf;

import br.com.nestec.crea20.model.Address;
import br.com.nestec.crea20.model.rf.InspectionReport;
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
@Table(name = "notificado")
public class Notified {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cpfcnpj")
    private String cpfcnpj;
    @Column(name = "nome")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "nome_fantasia")
    private String fantasyName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_endereco"))
    private Address address;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relatorio_fiscalizacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private InspectionReport inspectionReport;
}
