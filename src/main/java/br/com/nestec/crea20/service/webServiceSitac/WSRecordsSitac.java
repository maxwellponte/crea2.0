package br.com.nestec.crea20.service.webServiceSitac;

import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.security.CrypDecrypUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

@Service
public class WSRecordsSitac {
    public static Map<Integer, String> cadastrarRF(User usuario, String json) {

        Map<Integer, String> retorno = new HashMap<Integer, String>();

        try {

            if (json != null) {

                if (json != "") {

                    String jsonAlterado = "[" + json + "]";

                    // sitac.crea-ce.org.br
                    String endereco = "https://crea-ce.sitac.com.br/app/webservices/restful/salvarRelatorioFiscalizacao";

                    CloseableHttpClient client = HttpClientBuilder.create().build();
                    HttpPost requisicao = new HttpPost(endereco.trim());
                    StringEntity params = new StringEntity(jsonAlterado.toString(), "UTF-8");
                    requisicao.setHeader("Content-type", "application/json; charset=utf-8");
                    requisicao.setEntity(params);

                    String senha = CrypDecrypUtil.decriptografarString(usuario.getPassword());
                    String basic_auth = new String(Base64.encodeBase64((usuario.getLoginSitac() + ":" + senha).getBytes()));
                    requisicao.addHeader("Authorization", "Basic " + basic_auth);

                    retorno = new HashMap<Integer, String>();

                    HttpResponse response = client.execute(requisicao);
                    Integer http_status = response.getStatusLine().getStatusCode();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                    StringBuffer result = new StringBuffer();
                    String line = "";
                    while ((line = rd.readLine()) != null) {
                        result.append(line);
                    }
                    retorno.put(http_status, result.toString());

                    return retorno;

                } else {

                    retorno.put(1, "JSON nao definido");
                    return retorno;
                }
            } else {
                retorno.put(2, "JSON Nulo");

                return retorno;
            }
        } catch (Exception e) {

            e.getStackTrace();
            retorno.put(3, "Erro durante a gravacao da RF no servidor do SITAC: " + e.getMessage());
            return retorno;
        }

    }
}
