package com.dharbor.talent.managervacations.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = Constants.UsersTable.NAME)
public class User {

    @Id
    @Column(name = Constants.UsersTable.Id.NAME)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Constants.UsersTable.Email.NAME, length = Constants.UsersTable.Email.LENGTH, nullable = false)
    private String email;
    @Column(name = Constants.UsersTable.Password.NAME, length = Constants.UsersTable.Password.LENGTH, nullable = false)
    private String password;

    @Column(name = Constants.UsersTable.CreateDate.NAME, nullable = false)
    private Date createDate;
    //private String role;
}
