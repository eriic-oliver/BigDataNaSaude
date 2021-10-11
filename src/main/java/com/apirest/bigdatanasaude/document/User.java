package com.apirest.bigdatanasaude.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class User {

    @Id
    private String id;
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
    private String email;
    private String contatoEmergencia;
    private String tipoSanguineo;

    public User(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
