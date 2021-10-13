package br.com.nestec.crea20.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Link {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "descricao")
    private String description;
    @Column(name = "icone")
    private String icon;
    private String url;
    @Column(name = "ordem")
    private Integer order;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
