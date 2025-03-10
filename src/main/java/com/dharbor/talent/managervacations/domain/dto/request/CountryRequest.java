package com.dharbor.talent.managervacations.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
public class CountryRequest {
    private String code;
    private String name;

    public boolean codeIsValid(String code) {
        return code == null || code.isEmpty();
    }

    public boolean nameIsValid(String name) {
        return name == null || name.isEmpty();
    }
}
