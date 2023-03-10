package com.thierry.fundus.services;

import com.thierry.fundus.exceptions.UserNotFoundException;
import com.thierry.fundus.models.User;
import com.thierry.fundus.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao{

    private final UserRepository userRepo;

    public UserDaoImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User saveUser(User data) {
        return userRepo.save(data);
    }

    @Override
    public User findUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

    }

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUsernameContainingIgnoreCase(username);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public User updateUser(Integer id, User data) {
        var user = findUserById(id);
        user.setBirthDate(data.getBirthDate());
        user.setUsername(data.getUsername());
        return userRepo.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }
}
