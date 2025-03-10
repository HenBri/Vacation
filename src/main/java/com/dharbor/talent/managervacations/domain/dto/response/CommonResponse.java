package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import lombok.*;

import org.apache.coyote.Response;
@Getter
@Setter
@AllArgsConstructor
public class CommonResponse extends ResponseConstant{
   private String statusCode;
   private String message;
}
