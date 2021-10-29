package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.model.art.ARTActivity;
import br.com.nestec.crea20.model.art.ARTContract;
import br.com.nestec.crea20.model.art.ARTSituation;
import br.com.nestec.crea20.model.art.Art;
import br.com.nestec.crea20.repository.ArtIRepository;
import br.com.nestec.crea20.security.CrypDecrypUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static antlr.build.ANTLR.root;

@Service
public class ArtServiceImp implements ArtService{
    @Autowired
    LoggedUser loggedUser;
    @Autowired
    ArtIRepository artIRepository;

    @Override
    public ResponseEntity<String> getArt(String numberArt) throws JsonProcessingException {
        try {
            String url = "https://crea-ce.sitac.com.br/app/webservices/restful/getArtByNumero?numero="+numberArt;
            User user = loggedUser.returnUserLog();
            String basicAuth = "Basic " + DatatypeConverter.printBase64Binary((user.getLoginSitac() + ":" + CrypDecrypUtil.decriptografarString(user.getPassword())).getBytes());
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
            String sub = response.getBody().substring(1,response.getBody().length() - 1);
            JSONObject jsonObject = new JSONObject(sub);
            List<Art> arts = new ArrayList<>();
            JSONArray arrayArt = jsonObject.getJSONArray("JSON");
            for (int i = 0; i < arrayArt.length();i++){
                JSONObject jsonArt = arrayArt.getJSONObject(i);
                Art art = new Art();
                art.setNumber(jsonArt.getString("numero"));
                art.setType(jsonArt.getString("tipo"));
                art.setType(jsonArt.getString("profissional"));
                art.setCompany(jsonArt.getString("empresa"));
                art.setGoal(jsonArt.getString("finalidade"));
                art.setTechnicalParticipation(jsonArt.getString("participacaoTecnica"));
                art.setClassEntity(jsonArt.getString("entidadeDeClasse"));
                art.setRegistrationForm(jsonArt.getString("formaDeRegistro"));
                art.setRateArt(jsonArt.getString("taxaArt"));
                art.setPayDay(jsonArt.getString("dataPagamento"));
                art.setRegistrationDate(jsonArt.getString("dataCadastro"));
                art.setFeePaid(jsonArt.getString("taxaPaga"));
                art.setObs(jsonArt.getString("observacao"));

                List<ARTContract> contratos = new ArrayList<ARTContract>();
                JSONArray arrayContratos = jsonObject.getJSONArray("contratos");
                for (int j = 0; j < arrayContratos.length();j++){
                    JSONObject jsonContratos = arrayContratos.getJSONObject(j);
                    ARTContract contract = new ARTContract();
                    contract.setNumber(jsonContratos.getString("numero"));
                    contract.setValue(jsonContratos.getString("valor"));
                    contract.setContractDate(jsonContratos.getString("dataCadastro"));
                    contract.setStartDate(jsonContratos.getString("dataInicio"));
                    contract.setEndDate(jsonContratos.getString("dataFim"));
                    contract.setUnconstitutionalAction(jsonContratos.getString("acaoInstitucional"));
                    contract.setContractor(jsonContratos.getString("contratante"));
                    contract.setOwner(jsonContratos.getString("proprietario"));
                    contract.setAddress(jsonContratos.getString("endereco"));
                    contratos.add(contract);
                }
                List<ARTActivity> atividades = new ArrayList<ARTActivity>();
                JSONArray arrayAtividades = jsonObject.getJSONArray("atividades");
                for (int z = 0; z < arrayAtividades.length();z++){
                    JSONObject jsonAtividades = arrayAtividades.getJSONObject(z);
                    ARTActivity activity = new ARTActivity();
                    activity.setLevel(jsonAtividades.getString("nivel"));
                    activity.setSubordinateActivity(jsonAtividades.getString("atividadeSubordinada"));
                    activity.setServiceActivity(jsonAtividades.getString("atividadeServico"));
                    activity.setQuantity(jsonAtividades.getString("quantidade"));
                    activity.setUnitMeasurement(jsonAtividades.getString("unidadeMedida"));
                    atividades.add(activity);
                }
                List<ARTSituation> situacoes = new ArrayList<ARTSituation>();
                JSONArray arraySituacoes = jsonObject.getJSONArray("situacoes");
                for (int k = 0; k < arraySituacoes.length();k++){
                    JSONObject jsonSituacoes = arraySituacoes.getJSONObject(k);
                    ARTSituation situation = new ARTSituation();
                    situation.setSituation(jsonSituacoes.getString("situacao"));
                    situation.setDescription(jsonSituacoes.getString("descricao"));
                    situation.setDate(jsonSituacoes.getString("data"));
                    situation.setHour(jsonSituacoes.getString("hora"));
                    situacoes.add(situation);
                }
                art.setSituationAnalyze(jsonArt.getString("situacaoAnalise"));
                art.setLowSituation(jsonArt.getString("situacaoBaixa"));
                art.setTicket(jsonArt.getString("boleto"));
                art.setPayment(jsonArt.getString("pagamento"));
                arts.add(art);
            }
            Gson gson = new Gson();
            return ResponseEntity.ok(gson.toJson(arts));
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
