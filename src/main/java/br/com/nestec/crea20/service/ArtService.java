package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.art.Art;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ArtService {
    ResponseEntity<String> getArt(String numberArt) throws JsonProcessingException;
}
