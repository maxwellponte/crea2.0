package br.com.nestec.crea20.model;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter
@Table(name = "company_address") @NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "tipo_logradouro", nullable = false)
    private String streetTipe;
    @Column(nullable = false, name = "logradouro")
    private String publicPlace;
    @Column(nullable = false, name = "numero")
    private String number;
    @Column(name = "complemento")
    private String complement;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String uf;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String tel;
    @Column(nullable = false)
    private String latidude;
    @Column(nullable = false)
    private String longitude;
}