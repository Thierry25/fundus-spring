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

    public User findUserById(Integer id){
        return userDao.findUserById(id);
    }

    public User findByUsername(String username){
        return userDao.findUserByUsername(username);
    }

    public User updateUser(Integer id, User userData){
        return userDao.updateUser(id, userData);
    }

    public void deleteUser(Integer id){
        userDao.deleteUserById(id);
    }
}
