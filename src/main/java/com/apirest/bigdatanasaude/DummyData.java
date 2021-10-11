package com.apirest.bigdatanasaude;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final UserRepository userRepository;

    DummyData(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        userRepository.deleteAll()
                .thenMany(
                        Flux.just("Fulano", "Bertano", "Ciclano",
                                "Daltrano", "Joãozinho", "Mariazinha")
                                .map(nome -> new User(UUID.randomUUID().toString(), nome))
                                .flatMap(userRepository::save))
                                .subscribe(System.out::println);
    }
}
