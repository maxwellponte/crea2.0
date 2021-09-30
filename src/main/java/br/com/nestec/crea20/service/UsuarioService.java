package br.com.nestec.crea20.service;


import br.com.nestec.crea20.model.UsuarioModel;
import br.com.nestec.crea20.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    //consulta do usuario por login
    @Override
    public UserDetails loadUserByUserName(String login)
            throws BadCredentialsException, DisabledException {
        UsuarioModel usuario = usuarioRepository.findByCpf(login);

        if (usuario == null)
            throw new BadCredentialsException("Usuário não encontrado no sistema!");
        if (!usuario.getAtivo())
            throw new DisabledException("Usuário não está ativo no sistema!");

        return new UsuarioSecurityModel(
                usuario.getCpf(),
                usuario.getSenha(),
                usuario.getAtivo(),
                buscarPermissoesUsuario(usuario));
    }

    //busca as permissoes do usuario
    public List<GrantedAuthority> buscarPermissoesUsuario (UsuarioModel usuario) {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority("ADMIN"));
        return auths;
    }
}
