package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.UsuarioModel;
import br.com.nestec.crea20.repository.RoleIRepository;
import br.com.nestec.crea20.repository.UsuarioIRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UsuarioServiceImp implements UsuarioService{
   @Autowired @Qualifier("usuarioRepository") @NonNull
   private final UsuarioIRepository usuarioRepository;

   @Autowired @Qualifier("roleRepository") @NonNull
   private final RoleIRepository roleRepository;

    @Override
    public UsuarioModel salvarUsuario(UsuarioModel usuarioModel) {
        log.info("salvando o novo usuario {} no banco de dados", usuarioModel.getUserName());
        return usuarioRepository.save(usuarioModel);
    }

    @Override
    public Role salvarRole(Role role) {
        log.info("salvando a nova funcao {} no banco de dados", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUsuario(String username, String rolename) {
        log.info("adicionando a funcao {} ao usuario {}", rolename, username);
        UsuarioModel usuarioModel = usuarioRepository.findByUserName(username);
        Role role = roleRepository.findByName(rolename);
        usuarioModel.getRoles().add(role);

    }

    @Override
    public UsuarioModel getUsuario(String username) {
        log.info("buscando o usuario {}", username);
        return usuarioRepository.findByUserName(username);
    }

    @Override
    public List<UsuarioModel> getUsers() {
        log.info("buscando todos os usuarios");
        return usuarioRepository.findAll();
    }
}
