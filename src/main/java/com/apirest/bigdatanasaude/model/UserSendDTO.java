package com.apirest.bigdatanasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSendDTO {
    private String nome;
    private String cpf;
    private String rg;
    private String nomeMae;
    private String dtNascimento;
    private Long altura;
    private Long peso;
    private String endereco;
    private String cidade;
    private String bairro;
    private String complemento;
    private int endNumero;
    private String telefone;
    private int ddd;
    private String login;
    private String contatoEmergencia;
    private String tipoSanguineo;
    private String password;
}
