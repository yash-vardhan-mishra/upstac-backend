package org.upgrad.upstac.auth.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.upgrad.upstac.exception.AppException;
import org.upgrad.upstac.users.User;
import org.upgrad.upstac.users.UserService;
import org.upgrad.upstac.users.models.AccountStatus;
import org.upgrad.upstac.users.roles.UserRole;

import java.time.LocalDateTime;

import static org.upgrad.upstac.shared.DateParser.getDateFromString;


@Service
public class RegisterService {

    @Autowired
    private UserService userService;

    private static final Logger log = LoggerFactory.getLogger(RegisterService.class);


    public User addUser(RegisterRequest registerRequest) {
/*
* didn't write the separate logic like the solution, used addUser, addDoctor and addTester
* from userService which handled validation, added roles and status
* */
        try{
            User newUser  = userService.addUser(registerRequest);
            userService.saveInDatabase(newUser);
            return newUser;
        }catch (AppException error){
            throw new AppException(error.getMessage());
        }
    }

    public User addDoctor(RegisterRequest registerRequest) {

        try{
            User newDoctor  = userService.addDoctor(registerRequest);
            userService.saveInDatabase(newDoctor);
            return newDoctor;
        }catch (AppException error){
            throw new AppException(error.getMessage());
        }
    }


    public User addTester(RegisterRequest registerRequest) {
        try{
            User newTester  = userService.addTester(registerRequest);
            userService.saveInDatabase(newTester);
            return newTester;
        }catch (AppException error){
            throw new AppException(error.getMessage());
        }
    }
}
