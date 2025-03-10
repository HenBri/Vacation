package com.dharbor.talent.managervacations.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Entity
@Getter
@Setter
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "profile")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name =  "fristName", nullable = false, length = 100)
    private String fristName;

    @Column(name =  "lastName", nullable = false, length = 100)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name =  "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name =  "nickName", nullable = false, length = 100)
    private String nickName;

    @Column(name =  "imageMongo", length = 200)
    private String imageMongo;
    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = Constants.UsersTable.Id.NAME)
    private User user;
}
