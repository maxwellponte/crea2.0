package br.com.nestec.crea20.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public enum DocumentType {
    ART("ART"), TRT("TRT"), RRT("RRT"), RF_EXISTENTE("RF-Existente"), CONTRATO("Contrato"), OUTROS("Outros");

    private String description;
}
