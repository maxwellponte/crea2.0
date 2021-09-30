package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioIRepository extends JpaRepository<UsuarioModel, Long> {

}
