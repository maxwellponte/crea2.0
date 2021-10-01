package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleIRepository extends JpaRepository<Role, Long> {
    Role findByName(String nome);
}
