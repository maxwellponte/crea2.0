package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Link;
import org.springframework.stereotype.Service;

@Service
public interface LinkService {
    Link saveMenu(Link link);
    void deleteMenu(Link link);
}
