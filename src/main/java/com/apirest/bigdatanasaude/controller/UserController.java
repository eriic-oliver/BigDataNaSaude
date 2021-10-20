package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.model.LoginDTO;
import com.apirest.bigdatanasaude.repository.UserRepository;
import com.apirest.bigdatanasaude.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @GetMapping(value="/")
    @ApiOperation(value="Retorna todos os usuários")
    public Flux<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um usuário por ID")
    public Mono<User> getUser(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Salva um usuário")
    public Mono<User> postUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.save(user);
    }

    @PostMapping(value = "/validarSenha")
    @ApiOperation(value="Valida usuário")
    public ResponseEntity<String> validarSenha(@RequestBody LoginDTO dadosLoginDTO) throws Exception {

        Optional<User> optUser = userRepository.findByLogin(dadosLoginDTO.getEmail());
        if(optUser.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
        }
        User user = optUser.get();
        boolean valid = encoder.matches(dadosLoginDTO.getSenha(), user.getPassword());

        HttpStatus status = valid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;

        String token = userAuthenticationService.authenticate(dadosLoginDTO);
        return ResponseEntity.status(status).body(token);
    }
}
