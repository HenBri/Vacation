package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.domain.Vacation;
import lombok.Getter;
import lombok.Setter;
import org.apache.coyote.Response;

@Getter
@Setter
public class VacationReesponse extends CommonResponse{
    private Vacation vacation;

   // public VacationReesponse(StatusCodeResponse.SUCCESS_CODE, String message) {
   //     super(statusCode, message);
   // }
}
