package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.User;

import java.util.Optional;

public interface UserRepositoryPort {
	
	Optional<User> findById(Integer id);
	
	Optional<User> findByEmail(String email);
	
	User save(User user);

}
