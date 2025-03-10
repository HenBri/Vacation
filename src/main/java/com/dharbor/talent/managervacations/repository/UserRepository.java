package com.dharbor.talent.managervacations.repository;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTeam(Team team);
    List<User> deleteByTeam(Team team);
    List<User> deleteByCountries(Country country);
    List<User> find(Team team);
}
