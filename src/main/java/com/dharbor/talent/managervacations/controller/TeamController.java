package com.dharbor.talent.managervacations.controller;

import com.dharbor.talent.managervacations.domain.dto.request.TeamRequest;
import com.dharbor.talent.managervacations.domain.dto.response.team.DeleteTeamResponse;
import com.dharbor.talent.managervacations.domain.dto.response.team.GetTeamsResponse;
import com.dharbor.talent.managervacations.domain.dto.response.team.TeamResponse;
import com.dharbor.talent.managervacations.usecase.team.DeleteTeamUseCase;
import com.dharbor.talent.managervacations.usecase.team.GetAllTeamsUseCase;
import com.dharbor.talent.managervacations.usecase.team.GetTeamByIdUseCase;
import com.dharbor.talent.managervacations.usecase.team.SaveTeamUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@RestController
@RequestMapping("/Teams")
public class TeamController {
    @Autowired
    private DeleteTeamUseCase deleteTeamUseCase;
    @Autowired
    private GetAllTeamsUseCase getAllTeamsUseCase;
    @Autowired
    private GetTeamByIdUseCase getTeamByIdUseCase;
    @Autowired
    private SaveTeamUseCase saveTeamUseCase ;

    @PostMapping("/saveTeam")
    public TeamResponse save(@RequestBody TeamRequest teamRequest){
       return saveTeamUseCase.execute(teamRequest);
    }
    @GetMapping("GetById/{idTeam}")
    public TeamResponse getById(@PathVariable Long idTeam){
        return getTeamByIdUseCase.execute(idTeam);
    }
    @GetMapping("GetAll")
    public GetTeamsResponse getAll(){
        return getAllTeamsUseCase.execute();
    }
    @DeleteMapping("deleteById/{idTeam}")
    public DeleteTeamResponse deleteById(@PathVariable Long idTeam){
        return deleteTeamUseCase.execute(idTeam);
    }


}
