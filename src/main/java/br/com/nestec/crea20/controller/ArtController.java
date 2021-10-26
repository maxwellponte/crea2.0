package br.com.nestec.crea20.controller;

import br.com.nestec.crea20.annotation.ValidateUserAnnotation;
import br.com.nestec.crea20.model.art.Art;
import br.com.nestec.crea20.service.ArtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController @RequiredArgsConstructor @RequestMapping(path = "/recursosArt")
public class ArtController {

    @Autowired
    ArtService artService;

    @GetMapping(path = "/getArtPorNumero") @ValidateUserAnnotation
    public ResponseEntity<Art> getArt(@RequestParam String numberArt) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/recursosArt/getArtPorNumero").toUriString());
        if(numberArt != null)
            return ResponseEntity.created(uri).body(artService.getArt(numberArt));
        else{
            return null;
        }
    }
}
