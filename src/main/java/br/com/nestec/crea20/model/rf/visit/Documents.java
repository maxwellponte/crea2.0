package br.com.nestec.crea20.model.rf.visit;

import br.com.nestec.crea20.enums.DocumentType;
import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.rf.IRDocuments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "documento")
public class Documents {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero")
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento")
    private DocumentType documentType;
    @Column(name = "descricao")
    private String description;
    @Column(name = "fotos")
    @OneToMany(cascade = { CascadeType.ALL }, mappedBy = "documents", targetEntity = DocumentIMG.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Fetch(FetchMode.JOIN)
    private List<DocumentIMG> photos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "visita_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_visita"))
    private Visit visit;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empresa"))
    private Company company;
    @ManyToOne
    @JoinColumn(name = "ef_ID", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_empreendimento_documento"))
    private EnterpriseDocument enterpriseDocument;
}
