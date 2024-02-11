package org.walech.alm.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.walech.alm.system.model.DebtMaturityProfile;

public interface DebtMaturityProfileRepository extends JpaRepository<DebtMaturityProfile, String> {
    void deleteByBucket(String bucket);
}
