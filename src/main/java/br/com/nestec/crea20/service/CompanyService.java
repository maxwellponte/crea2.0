package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {
    Company saveCompany(Company company);
    void deleteCompany(String cnpj);
    List<Company> getCompanies();
}
