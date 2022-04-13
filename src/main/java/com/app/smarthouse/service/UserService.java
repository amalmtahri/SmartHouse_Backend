package com.app.smarthouse.service;

import com.app.smarthouse.model.User;
import com.app.smarthouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}
