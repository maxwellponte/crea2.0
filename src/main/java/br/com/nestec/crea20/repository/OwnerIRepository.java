package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerIRepository extends JpaRepository<Owner, Long> {
    Owner findByCpfCnpj(String cpfCnpj);
}
