package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.art.Art;
import org.springframework.stereotype.Service;

@Service
public interface ArtService {
    Art getArt(String numberArt);
}
