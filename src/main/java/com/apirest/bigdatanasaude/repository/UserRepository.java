package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {

    public Mono<User> findByLogin(String login);
}
