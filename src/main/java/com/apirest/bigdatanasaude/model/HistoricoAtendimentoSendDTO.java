package com.apirest.bigdatanasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoAtendimentoSendDTO {

    private String dtAtendimento;
    private String medico;
    private String idUsuario;
}
