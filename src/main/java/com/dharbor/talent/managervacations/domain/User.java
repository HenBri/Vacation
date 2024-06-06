package com.dharbor.talent.managervacations.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = Constants.UsersTable.NAME)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column(name = Constants.UsersTable.Id.NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.UsersTable.Email.NAME, length = Constants.UsersTable.Email.LENGTH, nullable = false)
    private String email;
    @Column(name = Constants.UsersTable.Password.NAME, length = Constants.UsersTable.Password.LENGTH, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = Constants.UsersTable.UserType.NAME,length = Constants.UsersTable.UserType.LENGTH,nullable = false)
    private UserType userType ;

    @Temporal(TemporalType.DATE)
    @Column(name = Constants.UsersTable.CreateDate.NAME, nullable = false)
    private Date createDate;

    @PrePersist
    void onPrePersist(){
        this.createDate= new Date();
    }
}
