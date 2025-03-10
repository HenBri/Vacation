package com.dharbor.talent.managervacations.usecase.user;

import com.dharbor.talent.managervacations.common.Message;
import com.dharbor.talent.managervacations.domain.Country;
import com.dharbor.talent.managervacations.domain.User;
import com.dharbor.talent.managervacations.domain.dto.request.UserRequest;
import com.dharbor.talent.managervacations.domain.dto.response.user.UserResponse;
import com.dharbor.talent.managervacations.exception.BadRequestExeption;
import com.dharbor.talent.managervacations.exception.DuplicateRegistrerException;
import com.dharbor.talent.managervacations.service.ICountryService;
import com.dharbor.talent.managervacations.service.IUserService;
import com.dharbor.talent.managervacations.utils.Utils;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CreateUserUseCase {

    @Autowired
    private IUserService userService;
    @Autowired
    private ICountryService countryService;
    @Autowired
    private Message message;

    public UserResponse execute(UserRequest userRequest, List<Long> countryIds){
        validateUser(userRequest);
        try {
            User userBuild = buildUser(userRequest);

            for (Long countryId : countryIds) {
                Country country = countryService.findById(countryId);
                userBuild.getCountries().add(country);
            }

            userService.save(userBuild);

            return buildUserResponse(userBuild);
        }catch (DataIntegrityViolationException exception){
            throw new DuplicateRegistrerException(message.getMessage("Exists.user.password.message"));
        }

    }
    public User buildUser(UserRequest userRequest){
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setUserType(userRequest.getType());
        return user;
    }

    private UserResponse buildUserResponse(User user){
        return new UserResponse(user);
    }
    private void validateUser(UserRequest userRequest){
        if (Utils.isNullOrEmpty(userRequest.getEmail())) {
            throw new BadRequestExeption(message.getMessage("NotNull.user.email.message"));
        }
        if (Utils.isNullOrEmpty(userRequest.getPassword())){
            throw new BadRequestExeption(message.getMessage("NotNull.user.password.message"));
        }
        if (Utils.isNullOrEmpty(userRequest.getType())){
            throw new BadRequestExeption(message.getMessage("NotNull.user.type.message"));
        }
    }

}
