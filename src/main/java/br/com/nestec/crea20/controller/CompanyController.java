package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @GetMapping("/listempresas")
    @RolesAllowed({"Gestor", "Fiscal"})
    public ResponseEntity<List<Company>> getCompanies() {
        return ResponseEntity.ok().body(companyService.getCompanies());
    }

    @PostMapping(path = "/empresa/salvar")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/empresa/salvar").toUriString());
        return ResponseEntity.created(uri).body(companyService.saveCompany(company));
    }
    @DeleteMapping (path = "/empresa/deletar")
    public void deleteUser(@RequestBody String cnpj){
        companyService.deleteCompany(cnpj);
    }
}
