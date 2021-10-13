package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkIRepository extends JpaRepository<Link, Long> {
}
