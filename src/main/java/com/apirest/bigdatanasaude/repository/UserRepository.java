package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.Optional;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    public Optional<User> findByLogin(String login);
}
