package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.UsuarioModel;
import br.com.nestec.crea20.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioModel> buscarTodos(){
        return usuarioService.listar();
    }

}
