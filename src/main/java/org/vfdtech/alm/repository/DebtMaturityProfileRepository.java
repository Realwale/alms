package org.vfdtech.alm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vfdtech.alm.model.DebtMaturityProfile;

public interface DebtMaturityProfileRepository extends JpaRepository<DebtMaturityProfile, String> {
    void deleteByBucket(String bucket);
}
