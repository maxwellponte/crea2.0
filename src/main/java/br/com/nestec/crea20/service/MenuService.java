package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.Menu;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    Menu saveMenu(Menu menu);
    void deleteMenu(Menu menu);
}
