package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.Vacation;
import com.dharbor.talent.managervacations.repository.VacationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacationServiceImpl implements IVacationService {

        private VacationRepository vacationRepository;
        public VacationServiceImpl(VacationRepository vacationRepository){
            this.vacationRepository = vacationRepository;
        }
    @Override
    public List<Vacation> getAll() {
        return vacationRepository.findAll();
    }

    @Override
    public List<Vacation> getVacationByUser(User user) {
        return vacationRepository.findByUser(user);
    }

    @Override
    public Vacation findById(Long id) {
        return vacationRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        vacationRepository.deleteById(id);
    }

    @Override
    public Vacation save(Vacation vacation) {
        return vacationRepository.save(vacation);
    }
    @Override
    public void deleteAllByUser(User user){
            vacationRepository.deleteByUser(user);
    }
}
