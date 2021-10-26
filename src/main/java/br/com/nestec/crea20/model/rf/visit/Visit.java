package br.com.nestec.crea20.model.rf.visit;


import br.com.nestec.crea20.enums.UF;
import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.model.rf.IRDocuments;
import br.com.nestec.crea20.model.rf.InspectionReport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity @Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visitas")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "rua")
    private String street;
    @Column(name = "numero")
    private String number;
    @Column(name = "cidade")
    private String city;
    @Column(name = "bairro")
    private String neighborhood;
    @Enumerated(EnumType.STRING)
    private UF uf;
    @Column(name = "pais")
    private String country;
    @Column(name = "complemento")
    private String complement;
    private String latitude;
    private String longitude;
    @Column(name = "data_visita")
    @Temporal(TemporalType.TIMESTAMP)
    private Date visitDate = new java.sql.Date(System.currentTimeMillis());
    @Column(name = "data_visita_servidor")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataVisitaPeloSistema = new java.sql.Date(System.currentTimeMillis());
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "visit", targetEntity = Documents.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    private List<Documents> documentos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Company company;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private User user;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relatorio_fiscalizacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private InspectionReport inspectionReport;
//    private Denuncia denuncia;
//    private Diligencia diligencia;
    @ManyToOne
    @JoinColumn(name = "route_ID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_rota"))
    private Route route;
    @Transient
    private Integer quantidadeART;
    @Transient
    private Integer quantidadeRRT;
    @Transient
    private Integer quantidadeTRT;
    @Transient
    private Integer quantidadeContrato;
    @Transient
    private Integer quantidadeRFExistente;
}
