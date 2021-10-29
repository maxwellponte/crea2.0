package br.com.nestec.crea20.service;

import br.com.nestec.crea20.model.rf.InspectionReport;
import br.com.nestec.crea20.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InspectionReportService {
    Object saveIR(InspectionReport inspectionReport);
    void deleteIR(Long id);
    List<InspectionReport> getIRs(User user);
}
