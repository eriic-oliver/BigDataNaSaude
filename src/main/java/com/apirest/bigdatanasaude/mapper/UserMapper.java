package com.apirest.bigdatanasaude.mapper;

import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.model.UserDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class UserMapper {
    /*
    public Optional<User> toUser(User user) {
        UserDTO userDTO = new UserDTO();
        user.subscribe(
                value -> {
                    userDTO.setId(value.getId());
                    userDTO.setCpf(value.getCpf());
                    userDTO.setRg(value.getRg());
                    userDTO.setDtNascimento(value.getDtNascimento());
                    userDTO.setAltura(value.getAltura());
                    userDTO.setPeso(value.getPeso());
                    userDTO.setEndereco(value.getEndereco());
                    userDTO.setCidade(value.getCidade());
                    userDTO.setBairro(value.getBairro());
                    userDTO.setComplemento(value.getComplemento());
                    userDTO.setEndNumero(value.getEndNumero());
                    userDTO.setTelefone(value.getTelefone());
                    userDTO.setDdd(value.getDdd());
                    userDTO.setLogin(value.getLogin());
                    userDTO.setContatoEmergencia(value.getContatoEmergencia());
                    userDTO.setTipoSanguineo(value.getTipoSanguineo());
                    userDTO.setPassword(value.getPassword());
                    userDTO.setNome(value.getNome());
                }
        );
        Optional<UserDTO> optionalUserDTO = Optional.of(userDTO);
        return optionalUserDTO;
    }
   /* public Optional<UserDTO> toUserDTO(Optional<User> us) {
        UserDTO userDTO = new UserDTO();
        User user = us.get();
                userDTO.setId(user.getId());
                userDTO.setCpf(user.getCpf());
                userDTO.setRg(user.getRg());
                userDTO.setDtNascimento(user.getDtNascimento());
                userDTO.setAltura(user.getAltura());
                userDTO.setPeso(user.getPeso());
                userDTO.setEndereco(user.getEndereco());
                userDTO.setCidade(user.getCidade());
                userDTO.setBairro(user.getBairro());
                userDTO.setComplemento(user.getComplemento());
                userDTO.setEndNumero(user.getEndNumero());
                userDTO.setTelefone(user.getTelefone());
                userDTO.setDdd(user.getDdd());
                userDTO.setLogin(user.getLogin());
                userDTO.setContatoEmergencia(user.getContatoEmergencia());
                userDTO.setTipoSanguineo(user.getTipoSanguineo());
                userDTO.setPassword(user.getPassword());
                userDTO.setNome(user.getNome());


        Optional<UserDTO> optionalUserDTO = Optional.of(userDTO);
        return optionalUserDTO;
    }*/
}
