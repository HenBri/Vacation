package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;

import java.util.List;
import java.util.Optional;

public interface IVacationService {
    List<Vacation> getAll();
    List<Vacation> getVacationByUser(User user);
    Vacation findById(Long id);
    void deleteById(Long id);
    Vacation save(Vacation vacation);
    void deleteAllByUser(User user);
}
