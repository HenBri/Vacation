package com.dharbor.talent.managervacations.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
    private Date createDate;
}
