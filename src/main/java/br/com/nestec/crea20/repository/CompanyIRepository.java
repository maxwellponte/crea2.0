package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyIRepository extends JpaRepository<Company, Long>{
    Company findByCnpj(String cnpj);
}
