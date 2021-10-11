package com.apirest.bigdatanasaude.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;

@Document
@Getter
@Setter
public class HistoricoAtendimento {

    @Id
    private String id;
    private String dtAtendimento;
    private String medico;
    private String idUsuario;

}
