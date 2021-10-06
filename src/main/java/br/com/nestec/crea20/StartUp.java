package br.com.nestec.crea20;

import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Component
public class StartUp implements InitializingBean {

    @Autowired
    UserService userService;

    @Override
    public void afterPropertiesSet(){
        Role roleAdmin = new Role(1L, "Administrador");
        userService.salvarRole(roleAdmin);
        userService.salvarRole(new Role(2L, "Fiscal"));
        userService.salvarRole(new Role(3L, "Gestor"));

        //userService.salvarUsuario(new User(1L, true, "Desenvolvedor", "12345678912",new Date(), "", "123456",new ArrayList<Role>(Arrays.asList(roleAdmin))));
        //userService.salvarUsuario(new User(1L, true, "Maxwell", "60351336303",new Date(), "antonio_maxwell@hotmail,com", "123456",new ArrayList<Role>(Arrays.asList(roleAdmin))));
    }
}
