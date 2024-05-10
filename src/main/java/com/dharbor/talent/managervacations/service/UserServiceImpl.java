package com.dharbor.talent.managervacations.service;

import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.repository.UserRepository;
import com.dharbor.talent.managervacations.repository.VacationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
