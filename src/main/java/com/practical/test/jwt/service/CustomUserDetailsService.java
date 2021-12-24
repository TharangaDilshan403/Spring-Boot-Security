package com.practical.test.jwt.service;

import com.practical.test.jwt.entity.User;
import com.practical.test.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user= userRepository.findByUserName(username);
       return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getUserPassword(),new ArrayList<>());
    }


}
