package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.repository.CompanyIRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Slf4j @RequiredArgsConstructor @Transactional
public class CompanyServiceImp implements CompanyService{
    @Autowired
    CompanyIRepository companyIRepository;

    @Override
    public Company saveCompany(Company company) {
        log.info("salvando a empresa {} no sistema.", company.getCorporateName());
        return companyIRepository.save(company);
    }

    @Override
    public void deleteCompany(String cnpj) {
        log.info("deletando a empresa com cnpj {} do banco de dados", cnpj);
        companyIRepository.delete(companyIRepository.findByCnpj(cnpj));
    }

    @Override
    public List<Company> getCompanies() {
        log.info("buscando todas as empresas");
        return companyIRepository.findAll();
    }
}
