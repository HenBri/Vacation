package com.dharbor.talent.managervacations.usecase.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.response.team.GetTeamsResponse;
import com.dharbor.talent.managervacations.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class GetAllTeamsUseCase {
    @Autowired
    private ITeamService teamService;

    public GetTeamsResponse execute(){
        List<Team> teams = teamService.getAll();
        GetTeamsResponse buildTeam = buildTeams(teams);
        return buildTeam;
    }
    private GetTeamsResponse buildTeams(List<Team> teams){
        return new GetTeamsResponse(teams);
    }


}
