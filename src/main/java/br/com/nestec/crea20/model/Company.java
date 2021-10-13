package br.com.nestec.crea20.model;

import lombok.*;

import javax.persistence.*;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    @Column(nullable = false, name = "razao_social")
    private String corporateName;
    @Column(nullable = false, unique = true, name = "nome_fantasia")
    private String fantasyName;
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(name = "observacao")
    private String Note;
    @Transient
    private Boolean checked;
    @OneToOne(fetch = FetchType.EAGER) @JoinColumn(name = "endereco_id")
    private Address address;
}
