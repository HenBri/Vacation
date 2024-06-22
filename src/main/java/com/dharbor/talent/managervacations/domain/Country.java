package com.dharbor.talent.managervacations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */

@Getter
@Setter
@Entity
@Table(name =Constants.CountryTable.NAME)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Country {
    @Id
    @Column(name = Constants.CountryTable.Id.NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.CountryTable.Code.NAME, length = Constants.CountryTable.Code.LENGTH, nullable = false)
    private String code;
    @Column(name= Constants.CountryTable.Name.NAME,length = Constants.CountryTable.Name.LENGTH, nullable = false)
    private String name;

}
