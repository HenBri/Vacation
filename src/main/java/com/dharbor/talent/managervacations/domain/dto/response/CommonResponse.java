package com.dharbor.talent.managervacations.domain.dto.response;

import com.dharbor.talent.managervacations.constant.ResponseConstant;
import org.apache.coyote.Response;

public abstract class CommonResponse extends ResponseConstant{
    private StatusCodeResponse statusCode;
    private  String messaje;
    //public CommonResponse(ResponseConstant.StatusCodeResponse.SUCCESS_CODE, String message) {


    //}
}
