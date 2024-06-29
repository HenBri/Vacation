package com.dharbor.talent.managervacations.usecase.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.response.team.DeleteTeamResponse;
import com.dharbor.talent.managervacations.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteTeamUseCase {
    @Autowired
    private ITeamService teamService;

    public DeleteTeamResponse execute(Long idTeam){
        Team team = teamService.findById(idTeam);
        DeleteTeamResponse buildTeam = build(team);
        teamService.deleteById(idTeam);
        return buildTeam;
    }
    private DeleteTeamResponse build(Team team){
        return new DeleteTeamResponse(team);
    }
}
