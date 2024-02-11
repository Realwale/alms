package org.walech.alm.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.walech.alm.system.dto.DebtMaturityResponse;
import org.walech.alm.system.service.DebtMaturityProfileService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compute/debt-maturity")
public class DebtMaturityProfileController {

    private final DebtMaturityProfileService debtMaturityProfileService;

    @GetMapping
    public ResponseEntity<DebtMaturityResponse> computeDebtMaturity(
            @RequestParam(required = false) Long days,
            @RequestParam(required = false) Long fromDay,
            @RequestParam(required = false) Long toDay) {

        String bucket;

        if (days != null) {
            bucket = days.toString();
        } else if (fromDay != null && toDay != null) {
            bucket = fromDay + "-" + toDay;
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        DebtMaturityResponse response = debtMaturityProfileService.computeAndSaveDebtMaturityProfileForBucket(bucket);
        return ResponseEntity.ok(response);
    }

}
