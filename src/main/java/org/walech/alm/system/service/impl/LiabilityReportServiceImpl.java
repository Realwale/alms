package org.walech.alm.system.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.walech.alm.system.model.LiabilityReport;
import org.walech.alm.system.repository.LiabilityReportRepository;
import org.walech.alm.system.service.LiabilityReportService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class LiabilityReportServiceImpl implements LiabilityReportService {

    private final LiabilityReportRepository liabilityReportRepository;

    /**
     * Save or update a liability report.
     *
     * @param liabilityReport the report to save or update.
     * @return the saved or updated report.
     */

    @Override
    public LiabilityReport saveOrUpdateLiabilityReport(LiabilityReport liabilityReport) {
        return liabilityReportRepository.save(liabilityReport);
    }

    /**
     * Retrieve all liability reports.
     *
     * @return a list of all liability reports.
     */
    @Override
    public List<LiabilityReport> getAllLiabilityReports() {
        return liabilityReportRepository.findAll();
    }

    /**
     * Retrieve a liability report by its ID.
     *
     * @param id the ID of the report to retrieve.
     * @return the found report or null if no report with the given ID exists.
     */
    @Override
    public LiabilityReport getLiabilityReportById(String id) {
        return liabilityReportRepository.findById(id).orElse(null);
    }

    /**
     * Delete a liability report by its ID.
     *
     * @param id the ID of the report to delete.
     */
    @Override
    public void deleteLiabilityReportById(String id) {
        liabilityReportRepository.deleteById(id);
    }

    /**
     * Logic to calculate the total face amount for all liabilities.
     * This is a sample business logic.
     *
     * @return the total face amount.
     */
    @Override
    public BigDecimal getTotalFaceAmount() {
        List<LiabilityReport> reports = liabilityReportRepository.findAll();
        return reports.stream()
            .map(LiabilityReport::getFaceAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Logic to find liabilities maturing within the next month.
     * This can be enhanced further as required.
     *
     * @return a list of liabilities maturing within the next month.
     */
    @Override
    public List<LiabilityReport> getLiabilitiesMaturingNextMonth() {
        LocalDate today = LocalDate.now();
        LocalDate oneMonthLater = today.plusMonths(1);
        return liabilityReportRepository.findAll().stream()
            .filter(report -> !report.getSettlementDate().isBefore(today) 
                           && !report.getSettlementDate().isAfter(oneMonthLater))
            .collect(Collectors.toList());
    }

    @Override
    public List<LiabilityReport> getAllLiabilityReportsWithinDays(Long first, Long second) {
        return liabilityReportRepository.findAll().stream()
                .filter(report -> {
                    LocalDate settlementDate = report.getSettlementDate();
                    long daysUntilSettlement = ChronoUnit.DAYS.between(LocalDate.now(), settlementDate);
                    return daysUntilSettlement >= first && daysUntilSettlement <= second;
                })
                .collect(Collectors.toList());
    }

}
