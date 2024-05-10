package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User findById(Long id);
    void deleteById(Long id);
    User save(User user);
}
