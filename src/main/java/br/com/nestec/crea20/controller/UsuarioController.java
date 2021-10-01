package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.UsuarioModel;
import br.com.nestec.crea20.service.UsuarioService;
import br.com.nestec.crea20.service.UsuarioServiceImp;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor @RequestMapping(path = "/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<UsuarioModel>> getUsuarios(){
        return ResponseEntity.ok().body(usuarioService.getUsers());
    }

    @PostMapping (path = "/usuario/salvar")
    public ResponseEntity<UsuarioModel> salvarUsuario(@RequestBody UsuarioModel usuarioModel){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.salvarUsuario(usuarioModel));
    }

    @PostMapping (path = "/role/salvar")
    public ResponseEntity<Role> salvarRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/salvar").toUriString());
        return ResponseEntity.created(uri).body(usuarioService.salvarRole(role));
    }

    @PostMapping (path = "/role/addaousuario")
    public ResponseEntity<?> addRoleAoUsuario(@RequestBody RoleToUserForm form){
        usuarioService.addRoleToUsuario(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }
}

@Data
class RoleToUserForm{
    private String username;
    private String rolename;
}
