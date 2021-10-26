package br.com.nestec.crea20.security;

import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.DatatypeConverter;

@Component
public class ValidateSitac {
    @Autowired
    UserService userService;

    public Boolean valSitac(String cpf, String password) throws Exception{
      try {
          String url = "https://crea-ce.sitac.com.br/app/webservices/movel_fiscalizacao/listTipoEndereco";
          User user = userService.getUser(cpf);
          if (user.getCpf().equals(cpf)) {
              String basicAuth = "Basic " + DatatypeConverter.printBase64Binary((user.getLoginSitac() + ":" + password).getBytes());
              HttpHeaders requestHeaders = new HttpHeaders();
              requestHeaders.add("Authorization", basicAuth);
              requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
              HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);
              RestTemplate restTemplate = new RestTemplate();
              ResponseEntity<String> response = restTemplate.exchange(
                      url,
                      HttpMethod.GET,
                      requestEntity,
                      String.class
              );
              if (response.getStatusCodeValue() == 200) {
                  return true;
              } else if (response.getStatusCodeValue() == 401) {
                  throw new Exception("Campo Senha invalida.");
              } else {
                  throw new Exception("Erro ao tentar acessar o SITAC.");
              }
          } else{
              return false;
          }
      }catch (Exception e) {
            return false;
        }
    }
}
