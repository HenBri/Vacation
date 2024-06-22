package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.Holiday;
import com.dharbor.talent.managervacations.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class HolidayServiceImpl implements IHolidayService{
    @Autowired
    private HolidayRepository holidayRepository;
    @Override
    public List<Holiday> getAll() {
        return holidayRepository.findAll();
    }

    @Override
    public List<Holiday> getHolidayByCountry(Country country) {
        return holidayRepository.findByCountry(country);
    }

    @Override
    public Holiday findById(Long idHoliday) {
        return holidayRepository.getById(idHoliday);
    }

    @Override
    public void deleteById(Long idHoliday) {
        holidayRepository.deleteById(idHoliday);
    }

    @Override
    public Holiday save(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    @Override
    public void deleteAllByCountry(Country country) {
        holidayRepository.deleteByCountry(country);
    }
}
