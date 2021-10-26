package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.rf.InspectionReport;
import br.com.nestec.crea20.model.User;
import br.com.nestec.crea20.repository.InspectionReportIRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service @Slf4j
public class InspectionReportServiceImp implements InspectionReportService{
    @Autowired
    InspectionReportIRepository inspectionReportIRepository;

    @Autowired
    LoggedUser loggedUser;

    @Override
    public InspectionReport saveIR(InspectionReport inspectionReport) {
        log.info("salvando o novo RF com descrição {} no banco de dados", inspectionReport.getDescription());
        inspectionReport.setSystemDate(new Date());
        User user = loggedUser.returnUserLog();
        inspectionReport.setUser(user);
        return inspectionReportIRepository.save(inspectionReport);
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
