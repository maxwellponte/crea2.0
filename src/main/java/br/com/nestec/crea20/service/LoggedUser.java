package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.security.GeradorKey;
import br.com.nestec.crea20.security.TokenJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;

@Component
public class LoggedUser {
    @Autowired
    UserService userService;

    public User returnUserLog(){
        HttpServletRequest req = getRequest();
        String token = req.getHeader("Authorization").substring("Bearer ".length());
        GeradorKey gKey = new GeradorKey();
        Key key = gKey.geradorKey();
        String cpf = TokenJWTUtil.recoverCpf(token, key);
        User user = userService.getUser(cpf);
        return user;
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}
