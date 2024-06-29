package com.dharbor.talent.managervacations.domain.dto.response.team;

import com.dharbor.talent.managervacations.domain.Team;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Setter
@Getter
public class GetTeamsResponse extends CommonResponse {
    List<Team> team;
    public GetTeamsResponse(List<Team> team){
        super(StatusCodeResponse.SUCCESS_CODE, StatusCodeResponse.SUCCESS_MSG);
        this.team = team;
    }
}
