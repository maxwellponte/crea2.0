package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.request.RoleToUserForm;
import br.com.nestec.crea20.service.UserService;
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
    UserService userService;

    @GetMapping(path = "/usuarios")
    public ResponseEntity<List<User>> getUsuarios(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping (path = "/usuario/salvar")
    public ResponseEntity<User> salvarUsuario(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.salvarUsuario(user));
    }

    @PostMapping (path = "/funcao/salvar")
    public ResponseEntity<Role> salvarRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/salvar").toUriString());
        return ResponseEntity.created(uri).body(userService.salvarRole(role));
    }

    @PostMapping (path = "/funcao/addaousuario")
    public ResponseEntity<?> addRoleAoUsuario(@RequestBody RoleToUserForm form){
        userService.addRoleToUsuario(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }

}
