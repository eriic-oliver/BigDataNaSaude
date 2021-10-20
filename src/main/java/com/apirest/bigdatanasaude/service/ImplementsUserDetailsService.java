package com.apirest.bigdatanasaude.service;

import com.apirest.bigdatanasaude.data.UserDatailsData;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplementsUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public ImplementsUserDetailsService(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userService.findByLogin(login).blockOptional();
        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuário [" + login + "] não encontrado!");
        }
        return new UserDatailsData(user);
    }
}
