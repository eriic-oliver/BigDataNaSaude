package com.apirest.bigdatanasaude.service;

import com.apirest.bigdatanasaude.data.UserDatailsData;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.service.user.UserServiceImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplementsUserDetailsService implements UserDetailsService {

    private final UserServiceImpl userService;

    public ImplementsUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
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
