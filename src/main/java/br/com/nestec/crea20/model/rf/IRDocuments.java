package br.com.nestec.crea20.model.rf;

import br.com.nestec.crea20.model.rf.InspectionReport;
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
@Table(name = "rf_documento")
public class IRDocuments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "arquivo", length = 10000000)
    private String file;
    @Column(name = "arquivo_bytes", length = 1000000)
    private byte[] fileBytes;
    @Column(name = "nome")
    private String name;
    @Column(name = "descricao")
    private String description;
    @Column(name = "data")
    private Date date;
    @Column(name = "tipo")
    private String type;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "relatorio_fiscalizacao_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_relatorio_fiscalizacao"))
    private InspectionReport inspectionReport;
}