package org.walech.alm.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.walech.alm.system.model.LiabilityReport;
import org.walech.alm.system.service.LiabilityReportService;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/liability-reports")
public class LiabilityReportController {

    private final LiabilityReportService liabilityReportService;

    @PostMapping
    public ResponseEntity<LiabilityReport> createLiabilityReport(@RequestBody LiabilityReport liabilityReport) {
        return new ResponseEntity<>(liabilityReportService.saveOrUpdateLiabilityReport(liabilityReport), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LiabilityReport>> getAllLiabilityReports() {
        return new ResponseEntity<>(liabilityReportService.getAllLiabilityReports(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LiabilityReport> getLiabilityReportById(@PathVariable String id) {
        LiabilityReport report = liabilityReportService.getLiabilityReportById(id);
        if(report != null) {
            return new ResponseEntity<>(report, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LiabilityReport> updateLiabilityReport(@PathVariable String id, @RequestBody LiabilityReport liabilityReport) {
        return new ResponseEntity<>(liabilityReportService.saveOrUpdateLiabilityReport(liabilityReport), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLiabilityReport(@PathVariable String id) {
        liabilityReportService.deleteLiabilityReportById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
