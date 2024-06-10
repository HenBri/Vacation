package com.dharbor.talent.managervacations.repository;

import com.dharbor.talent.managervacations.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */

public interface CountryRepository extends JpaRepository<Country, Long> {
}
