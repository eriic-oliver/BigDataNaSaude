package com.apirest.bigdatanasaude.service.authetication;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.repository.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthenticationService implements UserDetailsService{
	

	private final UserRepositoryPort repository;

	public AuthenticationService(UserRepositoryPort repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optional = repository.findByEmail(username);
		
		if(optional.isPresent()) {
			return (UserDetails) optional.get();
		}
		
		throw new UsernameNotFoundException("User not found");
	}	

}
