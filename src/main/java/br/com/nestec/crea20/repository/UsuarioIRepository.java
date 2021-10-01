package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioIRepository extends JpaRepository<UsuarioModel, Long>{
    UsuarioModel findByUserName(String nome);
}
