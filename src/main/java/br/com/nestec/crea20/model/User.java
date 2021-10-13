package br.com.nestec.crea20.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name = "ativo")
    private Boolean active;
    @Column(name = "nome")
    private String name;

    @Column(unique = true, length = 11)
    private String cpf;

    @Column(name="data_cadastro")
    private Date registrationDate;

    private String email;

    @Column(nullable = false, name = "senha") @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) @JoinColumn(name = "id_role")
    private Collection<Role> roles = new ArrayList<>();
}
