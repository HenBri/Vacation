package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;

import java.util.List;

public interface IVacationService {
    List<Vacation> getAll();
    List<Vacation> getVacationsByUser(User user);
    Vacation findById(Long id);
    void deleteById(Long id);
    Vacation save(Vacation vacation);
}
