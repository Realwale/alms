package org.walech.alm.system.service;

import org.walech.alm.system.model.LiabilityReport;

import java.math.BigDecimal;
import java.util.List;

public interface LiabilityReportService {
    LiabilityReport saveOrUpdateLiabilityReport(LiabilityReport liabilityReport);

    List<LiabilityReport> getAllLiabilityReports();

    LiabilityReport getLiabilityReportById(String id);

    void deleteLiabilityReportById(String id);

    BigDecimal getTotalFaceAmount();

    List<LiabilityReport> getLiabilitiesMaturingNextMonth();

    List<LiabilityReport> getAllLiabilityReportsWithinDays(Long first, Long second);
}
