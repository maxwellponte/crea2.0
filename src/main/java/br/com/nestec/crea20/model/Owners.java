package br.com.nestec.crea20.model;

import br.com.nestec.crea20.model.rf.InspectionReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "proprietarios")
public class Owners {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;
    @Column(name = "tipo_pessoa") @Transient
    private String kindPerson;
    @Column(name = "nome")
    private String name;
    private String email;
    @Column(name = "nome_fantasia")
    private String FantasyName;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id")
    private Address address;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relatorio_fiscalizacao_id")
    private InspectionReport inspectionReport;
}
