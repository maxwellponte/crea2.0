package br.com.nestec.crea20.service;


import br.com.nestec.crea20.model.UsuarioModel;
import br.com.nestec.crea20.repository.UsuarioIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioIRepository usuarioRepository;

    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioRepository.findAll();
    }

}
