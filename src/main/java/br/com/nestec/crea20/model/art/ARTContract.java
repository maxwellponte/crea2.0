package br.com.nestec.crea20.model.art;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ARTContract {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero")
    private String number;
    @Column(name = "valor")
    private String value;
    @Column(name = "data_contrato")
    private String contractDate;
    @Column(name = "data_inicio")
    private String startDate;
    @Column(name = "data_fim")
    private String endDate;
    @Column(name = "acao_inconstitucional")
    private String unconstitutionalAction;
    @Column(name = "contratante")
    private String contractor;
//    @Column(name = "proprietario")
//    private String proprietario;
//    @Column(name = "endereco")
//    private String endereco;
}
