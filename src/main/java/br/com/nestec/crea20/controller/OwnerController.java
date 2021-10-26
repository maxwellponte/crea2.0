package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.annotation.ValidateUserAnnotation;
import br.com.nestec.crea20.model.Owners;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.OwnerService;
import br.com.nestec.crea20.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.net.URI;
import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping(path = "/recursosFiscalizacao") @Slf4j
public class OwnerController {
    @Autowired
    UserService userService;
    @Autowired
    OwnerService ownerService;

    @GetMapping("/getListProprietarios")
    //@RolesAllowed("Fiscal")
    @ValidateUserAnnotation
    public ResponseEntity<List<Owners>> getOwners(@RequestParam String nomeCnpj) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/recursosFiscalizacao/getListProprietarios").toUriString());
        if(nomeCnpj != null)
            return ResponseEntity.created(uri).body(ownerService.getOwners(nomeCnpj));
        else{
            return null;
        }
    }

    @DeleteMapping (path = "/proprietario/deletar") @ValidateUserAnnotation
    public void deleteOwner(@RequestParam String cpfCnpj){
        ownerService.deleteOwner(cpfCnpj);
    }
}