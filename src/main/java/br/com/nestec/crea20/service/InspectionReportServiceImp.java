package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.rf.InspectionReport;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.repository.InspectionReportIRepository;
import br.com.nestec.crea20.service.webServiceSitac.WSRecordsSitac;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service @Slf4j
public class InspectionReportServiceImp implements InspectionReportService{
    @Autowired
    InspectionReportIRepository inspectionReportIRepository;

    @Autowired
    LoggedUser loggedUser;

    @Override
    public Object saveIR(InspectionReport inspectionReport) {
        log.info("salvando o novo RF com descrição {} no banco de dados", inspectionReport.getDescription());
        inspectionReport.setSystemDate(new Date());
        User user = loggedUser.returnUserLog();
        inspectionReport.setUser(user);
        inspectionReport.setWasSynchronizedWithSitac(false);
        Gson gson = new Gson();
        String json = gson.toJson(inspectionReport);
        Map<Integer, String> record = WSRecordsSitac.cadastrarRF(user, json);
        if (record.containsKey(200)) {
            inspectionReport.setWasSynchronizedWithSitac(true);
            return Response.ok(inspectionReportIRepository.save(inspectionReport));
        } else {
            inspectionReportIRepository.save(inspectionReport);
            return ResponseEntity.internalServerError().body("não foi possível sincronizar com o SITAC");
        }
    }

    @Override
    public void deleteIR(Long id) {
        log.info("deletando o RF com id {} do banco de dados", id);
        InspectionReport rf = inspectionReportIRepository.getById(id);
        inspectionReportIRepository.delete(rf);
    }

    @Override
    public List<InspectionReport> getIRs(User user) {
        log.info("listando todos os RF do Fiscal/Gestor {}",user.getName());
        return inspectionReportIRepository.findByUser(user);
    }
}
