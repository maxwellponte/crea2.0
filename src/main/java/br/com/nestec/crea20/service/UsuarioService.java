package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    UsuarioModel salvarUsuario(UsuarioModel usuarioModel);
    Role salvarRole(Role role);
    void addRoleToUsuario(String username, String rolename);
    UsuarioModel getUsuario(String username);
    List<UsuarioModel> getUsers();
}
