package com.dharbor.talent.managervacations.exception;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.constant.ResponseConstant;
import com.dharbor.talent.managervacations.domain.dto.response.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@RestControllerAdvice
public class RestExceptionHandler {
    @Autowired
    private Message message;

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<CommonResponse> unkownException(Exception ex){
        return new ResponseEntity<>(new CommonResponse("500",
                ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BadRequestExeption.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ResponseEntity<CommonResponse> badRequestException(BadRequestExeption ex){
        return new ResponseEntity<>(new CommonResponse("500",
                ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(value = {DuplicateRegistrerException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ResponseEntity<CommonResponse> duplicateRegister(DuplicateRegistrerException ex){
        return new ResponseEntity<>(new CommonResponse("500",
                ex.getMessage()),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
