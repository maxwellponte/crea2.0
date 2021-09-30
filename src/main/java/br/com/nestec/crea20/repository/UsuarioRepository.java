package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
}
