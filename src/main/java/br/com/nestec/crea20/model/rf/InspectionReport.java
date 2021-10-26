package br.com.nestec.crea20.model.rf;

import br.com.nestec.crea20.model.*;
import br.com.nestec.crea20.model.art.IRLinkedProtocol;
import br.com.nestec.crea20.model.rf.infraction.IRInfraction;
import br.com.nestec.crea20.model.rf.visit.Visit;
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
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Table(name = "relatorios_fiscalizacao")
public class InspectionReport {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero")
    private String number;
    @Column(name = "ano")
    private String year;
    @Column(name = "observacao")
    private String note;
    @Column(name = "descricao")
    private String description;
    @Column(name = "testemunha_nome")
    private String witnessName;
    @Column(name = "regional")
    private String regional;
    @Column(name = "numero_placa")
    private String plateNumber;
    @Column(name = "quantidade_funcionarios_obra")
    private String numberEmployees;
    @Column(name = "fase_obra_data_verificacao")
    private Date verificationDate;
    @Column(name = "data_sistema")
    private Date systemDate;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_acao_fiscalizatoria_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_acao_fiscalizatoria"))
    private InspectionAction typeInspectionAction;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grau_autuacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_grau_autuacao"))
    private ActingDegree actingDegree;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_empreendimento_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_tipo_empreendimento"))
    private TypeEnterprise typeEnterprise;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fase_obra_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_fase_obra"))
    private ConstructionPhase constructionPhase;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_endereco"))
    private Address address;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "camara_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_camara"))
    private Chamber chamber;
    @OneToMany(cascade = { CascadeType.ALL },mappedBy = "inspectionReport", targetEntity = IRInfraction.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    private Set<IRInfraction> infractions = new HashSet<>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "inspectionReport", targetEntity = IRAutoProcedures.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    private Set<IRAutoProcedures> autoProcedures = new HashSet<>();
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "inspectionReport", targetEntity = IRDocuments.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.SUBSELECT)
    private Set<IRDocuments> documents = new HashSet<>();
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "protocolo_vinculado_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_protocolo_vinculado"))
    private IRLinkedProtocol linkedProtocol;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario"))
    private User user;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visita_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_visita"))
    private Visit visit;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Company company;
    @Column(name = "tem_tramite_auto")
    private boolean hasAutoProcedures;
    @Column(name = "foi_sincronizado_com_sitac")
    private boolean wasSynchronizedWithSitac;
    @Column(name = "id_offline")
    private long idOffLine;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "proprietario_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_proprietario"))
    private Owners Owner;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "notificado_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_notificacao"))
    private Notified notified;
    @Column(name = "improcedente")
    private boolean unfounded;
    @Transient
    private String distance;

}
