package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.repository.UserRepository;
import com.apirest.bigdatanasaude.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
@Api(value="API REST Usuario")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/")
    @ApiOperation(value="Retorna todos os usuários")
    public Flux<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um usuário por ID")
    public Mono<User> getUser(@PathVariable String id){
        Mono<User> userMono = userService.findById(id).delayElement(Duration.ofMillis(1000));
        return userMono;
    }

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Salva um usuário")
    public Mono<User> postUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.save(user);
    }

  /*  @GetMapping(value = "/validarSenha")
    @ApiOperation(value="Valida usuário")
    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password){

        Mono<User> optUser = userRepository.findByLogin(login);
        if(optUser == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }
        User user = optUser;
        boolean valid = encoder.matches(password, user.getPassword());

        HttpStatus status = valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }*/
}
