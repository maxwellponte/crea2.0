package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User salvarUsuario(User user);
    User updateUser(User user);
    Role salvarRole(Role role);
    Role upadateRole(Role role);
    void addRoleToUsuario(String username, String rolename);
    User getUsuario(String username);
    List<User> getUsers();
}
