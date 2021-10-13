package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.request.RoleToUserForm;
import br.com.nestec.crea20.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @RequiredArgsConstructor @RequestMapping(path = "/api") @Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/listusuarios")
    public ResponseEntity<List<User>> getUsers(@RequestHeader("Authorization") String token) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser((String) auth.getPrincipal());
        if (token != null && user.getActive() != false) {
            try {
              return ResponseEntity.ok().body(userService.getUsers());
            }catch(Exception exception) {
                log.error("usuário inativo no sistema", exception.getMessage());
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping (path = "/usuario/salvar")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/usuario/salavar").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    @DeleteMapping (path = "/usuario/deletar")
    public void deleteUser(@RequestBody String cpf){
        userService.deleteUser(cpf);
    }

    @PostMapping (path = "/funcao/salvar")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/salvar").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @DeleteMapping (path = "/funcao/deletar")
    public void deleteRole(@RequestBody String nome){
        userService.deleteRole(nome);
    }

    @PostMapping (path = "/funcao/addaousuario")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
        userService.addRoleToUser(form.getCpf(), form.getRoleId());
        return ResponseEntity.ok().build();

    }

    @GetMapping (path = "/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            try {
                String refreshToken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshToken);
                String cpf = decodedJWT.getSubject();
                User user = userService.getUser(cpf);
                String acessToken = JWT.create()
                        .withSubject(user.getCpf())
                        .withExpiresAt(new Date(System.currentTimeMillis() +10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("acess_Token", acessToken);
                tokens.put("refresh_Token", refreshToken);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception){
                response.setHeader("error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                //response.sendError(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("mensagem_error", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }
        } else {
            throw new RuntimeException("Refresh token não encontrado");
        }
    }

}
