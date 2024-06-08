package com.dharbor.talent.managervacations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = Constants.VacationsTable.NAME)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Vacation {
    @Id
    @Column(name = Constants.VacationsTable.Id.NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name= Constants.VacationsTable.Type.NAME, length = Constants.VacationsTable.Type.LENGTH, nullable = false)
    private  VacationType vacationType;

    @Temporal(TemporalType.DATE)
    @Column(name = Constants.VacationsTable.DayOff.NAME, nullable = false)
    private Date dayOff;

    @Enumerated(EnumType.STRING)
    @Column(name = Constants.VacationsTable.Status.NAME, length = Constants.VacationsTable.Status.LENGTH, nullable = false)
    private VacationStatus vacationStatus;

    @ManyToOne
    @JoinColumn(name = Constants.VacationsTable.User.NAME, referencedColumnName = Constants.UsersTable.Id.NAME)
    private User user;

    @PrePersist
    void onPrePersist(){
        this.vacationStatus= vacationStatus.REQUESTED;
    }
}
