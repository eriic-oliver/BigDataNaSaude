package com.apirest.bigdatanasaude.service;

import com.apirest.bigdatanasaude.data.UserDatailsData;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplementsUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return new UserDatailsData(user);
    }
}
