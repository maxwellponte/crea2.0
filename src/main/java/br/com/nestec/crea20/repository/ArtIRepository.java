package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.art.Art;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtIRepository extends JpaRepository<Art, Long> {
}
