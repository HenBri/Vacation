package com.dharbor.talent.managervacations.repository;

import com.dharbor.talent.managervacations.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
