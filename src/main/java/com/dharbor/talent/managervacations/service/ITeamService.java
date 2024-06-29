package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.User;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
public interface ITeamService {
    List<Team> getAll();
    Team findById(Long id);
    void deleteById(Long id);
    Team save(Team team);

}
