package com.apirest.bigdatanasaude.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class HistoricoMedico {

    @Id
    private String id;
    private String comorbidade;
    private String alergia;
    private String doenca;
    private String medicacao;
    private String internacao;
    private String cirurgia;
    private String tabagismo;
    private String alcoolismo;
    private String idUsuario;

}