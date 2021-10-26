package br.com.nestec.crea20;

import br.com.nestec.crea20.model.Company;
import br.com.nestec.crea20.model.Link;
import br.com.nestec.crea20.model.Role;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.SecondaryTable;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import static br.com.nestec.crea20.enums.Gender.FEMININO;
import static br.com.nestec.crea20.enums.Gender.MASCULINO;

@Component
public class StartUp implements InitializingBean {

    @Autowired
    UserService userService;

    @Override
    public void afterPropertiesSet(){
//        Role roleAdmin = new Role(1L, "Administrador");
//        userService.saveRole(roleAdmin);
//        userService.saveRole(new Role(2L, "Fiscal"));
//        Role roleGestor = new Role(3L, "Gestor");
//        userService.saveRole(roleGestor);
//
//        userService.saveUser(new User(1L, true, "Desenvolvedor", "12345678912",new Date(), "desenvolvedor@gmail.com", FEMININO, "123456","dev","","",new byte[100],"",false,"","",new ArrayList<Role>(Arrays.asList(roleAdmin))));
//        userService.saveUser(new User(1L, true, "Maxwell", "60351336303",new Date(), "antonio_maxwell@hotmail,com", MASCULINO,"123456","maxwell.ponte","","",new byte[100],"",false,"","",new ArrayList<Role>(Arrays.asList(roleGestor))));
    }
}
