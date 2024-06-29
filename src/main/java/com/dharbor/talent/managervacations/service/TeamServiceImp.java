package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class TeamServiceImp implements ITeamService{

    @Autowired
    private TeamRepository teamRepository;


    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
