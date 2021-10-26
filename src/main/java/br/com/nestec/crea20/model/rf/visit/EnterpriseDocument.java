package br.com.nestec.crea20.model.rf.visit;

import br.com.nestec.crea20.enums.DocumentType;
import br.com.nestec.crea20.model.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "documento_empreendimento")
@Entity
public class EnterpriseDocument {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private DocumentType type;
    @Column(name = "numero")
    private String number;
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "data_validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private User user;
    @Column(name = "cnpj")
    private String cnpj;
}