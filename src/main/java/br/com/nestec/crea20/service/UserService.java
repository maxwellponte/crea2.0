package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    void deleteUser(String cpf);
    Role saveRole(Role role);
    void deleteRole(String nome);
    void addRoleToUser(String cpf, Long roleId);
    User getUser(String cpf);
    List<User> getUsers();
}
