package br.com.nestec.crea20.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity @Data
@Table(name = "usuario") @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Boolean ativo;
    private String userName;

    @Column(unique = true)
    private String cpf;

    @Column(name="data_cadastro")
    private Date dataCadastro;

    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToOne(fetch = FetchType.EAGER)
    private Role funcao;
}
