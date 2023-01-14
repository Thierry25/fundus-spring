package com.thierry.fundus.services;

import com.thierry.fundus.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoService {
    private final UserDao userDao;

    public UserDaoService(UserDao userDao){
        this.userDao = userDao;
    }

    public List<User> getAllUsers(){
        return userDao.findAllUsers();
    }
}
