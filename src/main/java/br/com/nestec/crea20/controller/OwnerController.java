package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.model.Owner;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.OwnerService;
import br.com.nestec.crea20.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping(path = "/recursosFiscalizacao") @Slf4j
public class OwnerController {
    @Autowired
    UserService userService;
    @Autowired
    OwnerService ownerService;

    @GetMapping("/getListProprietarios")
    public ResponseEntity<List<Owner>> getOwners(@RequestHeader("Authorization") String token) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser((String) auth.getPrincipal());
        try{
            if(token != null && user.getActive() != false) {
                return ResponseEntity.ok().body(ownerService.getOwners());
            }
        }catch (Exception exception){
            log.error("usuário inativo no sistema", exception.getMessage());
            return ResponseEntity.badRequest().build();
            }
        return ResponseEntity.badRequest().build();
    }
}
