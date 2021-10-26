package br.com.nestec.crea20.controller;


import br.com.nestec.crea20.annotation.ValidateUserAnnotation;
import br.com.nestec.crea20.model.rf.InspectionReport;
import br.com.nestec.crea20.service.InspectionReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController @RequestMapping("/recursosFiscalizacao")
public class InspectionReportController {
    @Autowired
    InspectionReportService inspectionReportService;
    @PostMapping(path = "/cadastrarRelatorioFiscalizacao") @ValidateUserAnnotation
    public ResponseEntity<InspectionReport> saveIR(@RequestBody InspectionReport inspectionReport){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/recursosFiscalizacao/cadastrarRelatorioFiscalizacao").toUriString());
        return ResponseEntity.created(uri).body(inspectionReportService.saveIR(inspectionReport));
    }
}
