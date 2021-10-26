package br.com.nestec.crea20.repository;

import br.com.nestec.crea20.model.rf.InspectionReport;
import br.com.nestec.crea20.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionReportIRepository extends JpaRepository<InspectionReport, Long> {
    List<InspectionReport> findByUser(User user);
}
