package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.response.user.GetUsersResponse;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Henry Aspeti
 * ShadowDevHat
 * U/J/A
 */
@Service
public class DeleteAllUsersByCountryUseCase {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICountryService countryService;

    public GetUsersResponse execute(Long countryId){
        Country country = countryService.findById(countryId);
        Set<User> users = country.getUsers();
        GetUsersResponse buildUsers = buildUser(users);
        for (User user : users) {
            user.getCountries().remove(country);
            userService.deleteById(user.getId());
        }

        country.getUsers().clear();
        countryService.save(country);

        return buildUsers;

    }

    public GetUsersResponse buildUser(Set<User> users){
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user);
        }
        return new GetUsersResponse(userList);
    }



}
