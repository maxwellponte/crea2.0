package br.com.nestec.crea20.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "funcao")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;

}
