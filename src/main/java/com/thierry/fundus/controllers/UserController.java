package com.thierry.fundus.controllers;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.thierry.fundus.services.UserDaoService;
import com.thierry.fundus.utils.Filtering;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserDaoService userDaoService;
    private final Filtering filtering;

    public UserController(UserDaoService userDaoService, Filtering filtering){
        this.userDaoService = userDaoService;
        this.filtering = filtering;
    }

    @GetMapping
    public MappingJacksonValue getAllUsers(){
        var users =  userDaoService.getAllUsers();
        return filtering.filter(users, "UserFilter", "username", "birthDate");
    }
}
