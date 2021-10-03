package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.repository.RoleIRepository;
import br.com.nestec.crea20.repository.UserIRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImp implements UserService {
   @Autowired
   private final UserIRepository usuarioRepository;

   @Autowired
   private final RoleIRepository roleRepository;

    @Override
    public User salvarUsuario(User user) {
        log.info("salvando o novo usuario {} no banco de dados", user.getUserName());
        return usuarioRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public Role salvarRole(Role role) {
        log.info("salvando a nova funcao {} no banco de dados", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public Role upadateRole(Role role) {
        if (roleRepository.findById(role.getId()) != null){}
        return null;
    }

    @Override
    public void addRoleToUsuario(String username, String rolename) {
        log.info("adicionando a funcao {} ao usuario {}", rolename, username);
        User user = usuarioRepository.findByUserName(username);
        Role role = roleRepository.findByName(rolename);
        user.setFuncao(role);
    }

    @Override
    public User getUsuario(String username) {
        log.info("buscando o usuario {}", username);
        return usuarioRepository.findByUserName(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("buscando todos os usuarios");
        return usuarioRepository.findAll();
    }
}
