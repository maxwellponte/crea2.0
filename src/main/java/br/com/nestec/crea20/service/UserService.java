package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User salvarUsuario(User user);
    Role salvarRole(Role role);
    void addRoleToUser(String cpf, Long roleId);
    User getUsuario(String cpf);
    List<User> getUsers();
}
