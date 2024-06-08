package com.dharbor.talent.managervacations.repository;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
    List<Vacation> findByUser(User user);
    void deleteByUser(User user);
}
