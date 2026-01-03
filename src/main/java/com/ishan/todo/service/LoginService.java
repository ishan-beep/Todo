package com.ishan.todo.service;

import com.ishan.todo.entity.LoginEntity;
import com.ishan.todo.repository.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class LoginService {

private final LoginRepository loginRepository;
public LoginService(LoginRepository loginRepository){
    this.loginRepository=loginRepository;
}

public boolean authenticate(String username,String password){
    Optional<LoginEntity> login=loginRepository.findByUsername(username);
    if(login.isEmpty()) return false;
    else return login.get().getPassword().equals(password);
}
}
