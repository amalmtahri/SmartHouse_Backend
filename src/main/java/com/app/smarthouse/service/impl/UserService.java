package com.app.smarthouse.service.impl;

import com.app.smarthouse.model.User;
import com.app.smarthouse.repository.UserRepository;
import com.app.smarthouse.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")@RequiredArgsConstructor

public class UserService implements IUserService , UserDetailsService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;



    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User getOne(String id){
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =this.userRepository.findByUserName(username);
        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();
        //add user roles
        //if(user.getHouse().getId()!=null)
        authorities.add(new SimpleGrantedAuthority("user"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
