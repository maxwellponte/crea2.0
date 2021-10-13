package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Link;
import br.com.nestec.crea20.repository.LinkIRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class LinkServiceImp implements LinkService{
    @Autowired
    LinkIRepository linkRepository;

    @Override
    public Link saveMenu(Link link) {
        log.info("salvando o novo Link {} no sistema",link.getDescription());
        return linkRepository.save(link);
    }

    @Override
    public void deleteMenu(Link link) {
        log.info("deletando o link {} do sistema",link.getDescription());
        linkRepository.delete(link);
    }
}
