package com.dharbor.talent.managervacations.repository;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
public interface HolidayRepository extends JpaRepository<Holiday, Long> {
    List<Holiday> findByCountry(Country country);
    void deleteByCountry(Country country);
}
