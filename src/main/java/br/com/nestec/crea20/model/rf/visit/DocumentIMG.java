package br.com.nestec.crea20.model.rf.visit;

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
@Table(name = "img_documento")
public class DocumentIMG {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Transient
    private DocumentIMGAux img;
    private byte[] bytes;
    @Column(name = "extensao")
    private String extensao;
    @Column(name = "tamanho")
    private Long size;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documento_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_documento"))
    private Documents documents;
}
