package com.dharbor.talent.managervacations.domain.dto.response.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class DeleteTeamResponse extends CommonResponse {
    Team team;
    public DeleteTeamResponse(Team team1){
        super(DeleteCodeResponse.SUCCESS_CODE, DeleteCodeResponse.SUCCESS_MSG);
        this.team = team1;
    }
}
