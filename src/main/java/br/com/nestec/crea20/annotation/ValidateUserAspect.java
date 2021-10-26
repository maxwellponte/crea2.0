package br.com.nestec.crea20.annotation;

import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.security.GeradorKey;
import br.com.nestec.crea20.security.TokenJWTUtil;
import br.com.nestec.crea20.security.ValidateSitac;
import br.com.nestec.crea20.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;

@Aspect
@Component
public class ValidateUserAspect {
    @Autowired
    UserService userService;

    @Pointcut("@annotation(br.com.nestec.crea20.annotation.ValidateUserAnnotation)")
    private void validateUserAnnotation() {
    }

    @Around("br.com.nestec.crea20.annotation.ValidateUserAspect.validateUserAnnotation()")
    public Object validateUser(ProceedingJoinPoint pjp) throws Throwable {
        try {
            HttpServletRequest req = getRequest();
            String token = req.getHeader("Authorization").substring("Bearer ".length());
            GeradorKey gKey = new GeradorKey();
            Key key = gKey.geradorKey();
            if (TokenJWTUtil.validToken(token, key)) {
                String cpf = TokenJWTUtil.recoverCpf(token, key);
                User user = userService.getUser(cpf);
                if (user.getActive()) {
                    return pjp.proceed();
                } else {
                    return ResponseEntity.badRequest().body("usuário inativo no sistema");
                }
            }
            return ResponseEntity.notFound().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return sra.getRequest();
    }
}

