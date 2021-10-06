package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIRepository extends JpaRepository<User, Long>{
    User findByUserName(String nome);
    User findByCpf(String cpf);
}
