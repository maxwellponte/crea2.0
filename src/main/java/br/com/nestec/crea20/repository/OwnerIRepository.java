package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnerIRepository extends JpaRepository<Owners, Long> {
    Owners findByCpfCnpj(String cpfCnpj);
    List<Owners> findByNameContaining(String name);
}
