package org.walech.alm.system.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.walech.alm.system.model.LiabilityReport;

public interface LiabilityReportRepository extends JpaRepository<LiabilityReport, String> {
}
