package br.com.nestec.crea20.model.rf.visit;

import javax.persistence.*;

@Table(name = "rota_arquivo")
@Entity
public class RouteFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descricao")
    private String description;
    private byte[] bytes;
    @Column(length = 10000000)
    private String base64;
    @Column(name = "tamanho")
    private String size;
    @Column(name = "quantidade_linhas")
    private String qtdLines;
}