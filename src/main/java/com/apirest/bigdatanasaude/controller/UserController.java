package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.model.UserSendDTO;
import com.apirest.bigdatanasaude.repository.UserRepository;
import com.apirest.bigdatanasaude.service.user.UserService;
import com.apirest.bigdatanasaude.service.validacao.ValidaCPF;
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
@Api(value="API REST - Usuario", tags = "Usuário", description = "Métodos relacionados a usuários")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value="/")
    @ApiOperation(value="Retorna todos os usuários", response = User[].class, notes = "O endpoint requer token de autenticação e retorna todos" +
            " os registros de usuários cadastrados na base de dados.")
    public Flux<User> getUsers(){
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um usuário por ID", response = User.class, notes = "O endpoint requer token de autenticação, ID do usuário como" +
            " parâmetro e retorna todos os dados do usuário selecionado.")
    public Mono<User> getUser(@PathVariable String id){
        Mono<User> userMono = userService.findById(id).delayElement(Duration.ofMillis(1000));
        return userMono;
    }

    @PutMapping(value = "/alterar")
    @ApiOperation(value = "Altera um usuário", response = User.class, notes = "O endpoint requer token de autenticação. Deve ser passado no body " +
            "da requisição um objeto JSON contendo os dados do usuário e seu respectivo ID, todos os campos são obrigatórios.")
    public Mono<User> putHistorico(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Salva um usuário", response = UserSendDTO.class, notes = "O endpoint não requer token de autenticação. Deve ser passado no body " +
            "da requisição um objeto JSON contendo os dados do usuário, todos os campos são obrigatórios. Se o login do usuário passado no body " +
            "da requisição corresponder ao login de algum usuário já cadastrado no banco, a aplicação retornará um erro de status 400 - Bad Request.")
    public ResponseEntity postUser(@RequestBody User user){
        Optional<User> jaCadastrado = userService.findByLogin(user.getLogin()).blockOptional();
        if(jaCadastrado.get() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já cadastrado");
        }
        if(!ValidaCPF.isCPF(user.getCpf())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF incorreto");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(user).blockOptional());
    }

// Filtrar

// Bloquear


}
