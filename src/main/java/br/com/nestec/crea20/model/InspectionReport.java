package br.com.nestec.crea20.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InspectionReport {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
