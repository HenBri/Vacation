package com.dharbor.talent.managervacations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Getter
@Setter
@Entity
@Table(name = Constants.HolidayTable.NAME)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Holiday {

    @Id
    @Column(name = Constants.HolidayTable.Id.NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.HolidayTable.Reason.NAME, length = Constants.HolidayTable.Reason.LENGTH, nullable = false)
    private String reason;

    @Temporal(TemporalType.DATE)
    @Column(name = Constants.HolidayTable.Date.NAME, nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name = Constants.HolidayTable.Country.NAME, referencedColumnName = Constants.CountryTable.Id.NAME)
    private Country country;

}
