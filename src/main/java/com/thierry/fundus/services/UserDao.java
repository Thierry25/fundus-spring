package com.thierry.fundus.services;

import com.thierry.fundus.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    User saveUser(User data);
    User findUserById(Integer id);
    User findUserByUsername(String username);
    void deleteUserById(Integer id);
    User updateUser(Integer id, User data);
    List<User> findAllUsers();
}
