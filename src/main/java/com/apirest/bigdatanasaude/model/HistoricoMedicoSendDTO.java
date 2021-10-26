package com.apirest.bigdatanasaude.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoMedicoSendDTO {

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
