package com.ishan.todo.service.impl;

import com.ishan.todo.entity.LoginEntity;
import com.ishan.todo.repository.LoginRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements UserDetailsService {

    private LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository){
        this.loginRepository=loginRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        LoginEntity login=loginRepository.findByUsername(username);
        if(login==null){
            throw new UsernameNotFoundException("user is not found");

        }
        return org.springframework.security.core.userdetails.User
                .withUsername(login.getUsername())
                .password(login.getPassword())
                .build();
    }

}
