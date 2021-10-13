package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Menu;
import br.com.nestec.crea20.repository.MenuIRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service @Slf4j
public class MenuServiceImp implements MenuService{
    @Autowired
    MenuIRepository menuRepository;

    @Override
    public Menu saveMenu(Menu menu) {
        log.info("salvando o novo Menu {} no sistema",menu.getDescription());
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        log.info("deletando o menu {} do sistema",menu.getDescription());
        menuRepository.delete(menu);
    }
}
