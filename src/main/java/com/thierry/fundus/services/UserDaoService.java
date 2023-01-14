package com.thierry.fundus.services;

import com.thierry.fundus.models.Request;
import com.thierry.fundus.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public User createUser(User data){
        return userDao.saveUser(data);
    }

    public List<Request> getFilteredRequests(Integer id, String filter){
        var user = userDao.findUserById(id);
        return user.getRequests().stream().filter((request) -> request.getDescription()
                                                        .startsWith(filter))
                                                        .collect(Collectors.toList());
    }
}
