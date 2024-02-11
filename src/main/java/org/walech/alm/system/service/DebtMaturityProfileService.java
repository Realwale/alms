package org.walech.alm.system.service;

import jakarta.transaction.Transactional;
import org.springframework.data.util.Pair;
import org.walech.alm.system.dto.DebtMaturityResponse;

public interface DebtMaturityProfileService {

    @Transactional
    DebtMaturityResponse computeAndSaveDebtMaturityProfileForBucket(String bucket);

    Pair<Long, Long> determineDaysRangeForBucket(String bucket);
}
