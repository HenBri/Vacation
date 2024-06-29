package com.dharbor.talent.managervacations.usecase.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.response.team.TeamResponse;
import com.dharbor.talent.managervacations.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetTeamByIdUseCase {

    @Autowired
    private ITeamService teamService;

    public TeamResponse execute(Long idTeam){
        Team team = teamService.findById(idTeam);
        TeamResponse teamBuild = build(team);
        return teamBuild;
    }
    private TeamResponse build(Team team){
        return new TeamResponse(team);
    }
}
