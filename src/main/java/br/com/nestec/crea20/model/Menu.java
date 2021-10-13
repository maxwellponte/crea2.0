package br.com.nestec.crea20.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descricao", unique = true)
    private String description;
    @Column(name = "icone")
    private String icon;
    private String url;
    @OneToMany(mappedBy = "menu" , fetch = FetchType.EAGER)
    private List<Link> links;
}
