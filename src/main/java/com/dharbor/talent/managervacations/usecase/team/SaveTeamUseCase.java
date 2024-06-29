package com.dharbor.talent.managervacations.usecase.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.request.TeamRequest;
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
public class SaveTeamUseCase {
    @Autowired
    private ITeamService teamService;

    public TeamResponse execute(TeamRequest teamRequest){
        Team team = build(teamRequest);
        TeamResponse teamResponse= builTeamResponse(team);
        teamService.save(team);
        return teamResponse;
    }
    private Team build(TeamRequest teamRequest){
        Team team = new Team();
        team.setNameTeam(teamRequest.getName());
        return team;
    }
    private TeamResponse builTeamResponse(Team team){
        return new TeamResponse(team);
    }
}
