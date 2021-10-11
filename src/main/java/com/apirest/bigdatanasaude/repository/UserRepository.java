package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
