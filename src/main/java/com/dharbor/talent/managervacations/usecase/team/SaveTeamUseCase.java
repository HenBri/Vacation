package com.dharbor.talent.managervacations.usecase.team;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.request.TeamRequest;
import com.dharbor.talent.managervacations.domain.dto.response.team.TeamResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
import com.dharbor.talent.managervacations.service.ITeamService;
import com.dharbor.talent.managervacations.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
    @Autowired
    private Message message;

    public TeamResponse execute(TeamRequest teamRequest){
        validateTeam(teamRequest);

        try {
            return builTeamResponse(
                    teamService.save(
                            build(teamRequest)
                    )
            );
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRegistrerException(message.getMessage("Exists.holiday.message"));
        }


    }
    private Team build(TeamRequest teamRequest){
        Team team = new Team();
        team.setNameTeam(teamRequest.getName());
        return team;
    }
    private TeamResponse builTeamResponse(Team team){
        return new TeamResponse(team);
    }
    private void validateTeam(TeamRequest teamRequest){
        if (Utils.isNullOrEmpty(teamRequest.getName())) {
            throw new BadRequestExeption(message.getMessage("NotNull.team.name.message"));
        }

    }
}
