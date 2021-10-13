package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuIRepository extends JpaRepository<Menu, Long> {
}
