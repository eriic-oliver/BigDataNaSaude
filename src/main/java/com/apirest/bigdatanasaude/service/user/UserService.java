package com.apirest.bigdatanasaude.service.user;

import com.apirest.bigdatanasaude.document.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> findAll();

    Mono<User> findById(String id);

    Mono<User> save(User user);

    Mono<User> findByLogin(String login);
}
