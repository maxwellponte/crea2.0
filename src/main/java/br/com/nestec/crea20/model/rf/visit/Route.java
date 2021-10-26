package br.com.nestec.crea20.model.rf.visit;

import br.com.nestec.crea20.enums.ImportType;
import br.com.nestec.crea20.enums.StatusRoute;
import br.com.nestec.crea20.model.Address;
import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.User;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "rota")
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codigo")
    private Integer code;
    @Column(name = "matricula_fiscal")
    private String taxRegistration;
    @Column(name = "latitude")
    private String latitude;
    @Column(name = "longitude")
    private String longitude;
    @Column(name = "descricao")
    private String description;
    @Column(name = "tipo_descricao")
    private String descriptionTypo;
    @Column(name = "data_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHour;
    @Column(name = "data_importacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHourImport;
    @Column(name = "data_conclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHourConclusion;
    @Column(name = "data_ultima_edicao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHourEdition;
    @Enumerated(EnumType.STRING)
    private ImportType type;
    @Enumerated(EnumType.STRING)
    private StatusRoute status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_que_editou_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_usuario_que_editou"))
    private User userEdit;
    @ManyToOne
    @JoinColumn(name = "import_file_ID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_arquivo_importacao"))
    private RouteImport ImportFile;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Company company;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_endereco"))
    private Address address;
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "route", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<Visit> visitas;
}