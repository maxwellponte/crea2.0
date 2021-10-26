package br.com.nestec.crea20.model.art;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import javax.persistence.*;
import java.util.List;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Art {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "numero", unique = true)
    private String number;
    @Column(name = "tipo")
    private String type;
    @Column(name = "profissional")
    private String professional;
    @Column(name = "empresa")
    private String company;
    @Column(name = "finalidade")
    private String goal;
    @Column(name = "participacao_tecnica")
    private String technicalParticipation;
    @Column(name = "entidade_de_classe")
    private String classEntity;
    @Column(name = "forma_de_registro")
    private String registrationForm;
    @Column(name = "taxa_art")
    private String rateArt;
    @Column(name = "data_pagamento")
    private String payDay;
    @Column(name = "data_cadastro")
    private String registrationDate;
    @Column(name = "taxa_paga")
    private String feePaid;
    private String obs;
    @Column(name = "ART_contratos")
    @ElementCollection(targetClass= ARTContract.class)
    private List<ARTContract> contracts;
    @Column(name = "ART_atividades")
    @ElementCollection(targetClass= ARTActivity.class)
    private List<ARTActivity> activities;
    @Column(name = "ART_situações")
    @ElementCollection(targetClass= ARTSituation.class)
    private List<ARTSituation> situations;
    @Column(name = "situacao_analise")
    private String situationAnalyze;
    @Column(name = "situacao_baixa")
    private String lowSituation;
    @Column(name = "boleto")
    private String ticket;
    @Column(name = "pagamento")
    private String payment;
//    @ElementCollection(targetClass= JRBeanCollectionDataSource.class)
//    private List<JRBeanCollectionDataSource> contractsDataSource;
//    @ElementCollection(targetClass= JRBeanCollectionDataSource.class)
//    private List<JRBeanCollectionDataSource> activitiesDataSource;
//    @ElementCollection(targetClass= JRBeanCollectionDataSource.class)
//    private List<JRBeanCollectionDataSource> situationsDataSource;
}
