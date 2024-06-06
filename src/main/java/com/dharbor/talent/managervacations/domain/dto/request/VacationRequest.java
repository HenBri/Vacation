package com.dharbor.talent.managervacations.domain.dto.request;

import com.dharbor.talent.managervacations.domain.VacationType;
import com.dharbor.talent.managervacations.domain.VacationStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter

public class VacationRequest {
    private VacationType type;
    private Date dayOff;
}
