package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/")
    public Flux<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<User> getUser(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping(value = "/salvar")
    public Mono<User> postUser(@RequestBody User user){
        return userService.save(user);
    }
}
