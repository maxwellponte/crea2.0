package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.repository.RoleIRepository;
import br.com.nestec.crea20.repository.UserIRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImp implements UserService, UserDetailsService {
   private final UserIRepository usuarioRepository;
   private final RoleIRepository roleRepository;
   private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        User user = usuarioRepository.findByCpf(cpf);
        if (user == null){
            log.error("usuario não encontrado");
            throw new UsernameNotFoundException("usuario não encontrado");
        } else {
            log.info("usuario encontrado no banco de dados com o cpf: {}",cpf);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new org.springframework.security.core.userdetails.User(user.getCpf(), user.getSenha(), authorities);
    }

    @Override
    public User salvarUsuario(User user) {
        log.info("salvando o novo usuario {} no banco de dados", user.getUserName());
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        return usuarioRepository.save(user);
    }

    @Override
    public Role salvarRole(Role role) {
        log.info("salvando a nova funcao {} no banco de dados", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String cpf, Long roleId) {
        log.info("adicionando a funcao {} ao usuario com cpf {}", roleId, cpf);
        User user = usuarioRepository.findByCpf(cpf);
        Optional<Role> role = roleRepository.findById(roleId);

        if (user.getCpf() != null && role.isPresent()){
            user.getRoles().add(role.get());
        }else {
            log.info("função ou usuario não encontrado no banco de dados");
        }
    }

    @Override
    public User getUsuario(String cpf) {
        log.info("buscando o usuario {}", cpf);
        return usuarioRepository.findByCpf(cpf);
    }

    @Override
    public List<User> getUsers() {
        log.info("buscando todos os usuarios");
        return usuarioRepository.findAll();
    }

}
