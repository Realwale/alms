package org.vfdtech.alm.service;

import jakarta.transaction.Transactional;
import org.springframework.data.util.Pair;
import org.vfdtech.alm.dto.DebtMaturityResponse;

public interface DebtMaturityProfileService {

    @Transactional
    DebtMaturityResponse computeAndSaveDebtMaturityProfileForBucket(String bucket);

    Pair<Long, Long> determineDaysRangeForBucket(String bucket);
}
