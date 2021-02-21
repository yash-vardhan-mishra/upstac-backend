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
        if(userService.findByUserName(registerRequest.getUserName()) != null){
            throw new AppException("User Name already exists");
        }else if(userService.findByEmail(registerRequest.getEmail()) != null){
            throw new AppException("Email already exists");
        }else if(userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null){
            throw new AppException("Phone Number already exists");
        }else{
            User newUser = userService.addUser(registerRequest);
            userService.saveInDatabase(newUser);
            return newUser;
        }
    }

    public User addDoctor(RegisterRequest registerRequest) {

        if(userService.findByUserName(registerRequest.getUserName()) != null){
            throw new AppException("User Name already exists");
        }else if(userService.findByEmail(registerRequest.getEmail()) != null){
            throw new AppException("Email already exists");
        }else if(userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null){
            throw new AppException("Phone Number already exists");
        }else{
            User newUser = userService.addDoctor(registerRequest);
            userService.saveInDatabase(newUser);
            return newUser;
        }
    }


    public User addTester(RegisterRequest registerRequest) {
        if(userService.findByUserName(registerRequest.getUserName()) != null){
            throw new AppException("User Name already exists");
        }else if(userService.findByEmail(registerRequest.getEmail()) != null){
            throw new AppException("Email already exists");
        }else if(userService.findByPhoneNumber(registerRequest.getPhoneNumber()) != null){
            throw new AppException("Phone Number already exists");
        }else{
            User newUser = userService.addTester(registerRequest);
            userService.saveInDatabase(newUser);
            return newUser;
        }
    }
}
