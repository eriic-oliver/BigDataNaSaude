package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.model.HistoricoMedicoSendDTO;
import com.apirest.bigdatanasaude.model.UserSendDTO;
import com.apirest.bigdatanasaude.service.historicoMedico.HistoricoMedicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/historico/medico")
@Api(value="API REST - Histórico Médico", tags = "Histórico Médico", description = "Métodos relacionados a históricos médico")
@CrossOrigin(origins = "*")
public class HistoricoMedicoController {

    @Autowired
    HistoricoMedicoService historicoMedicoService;

    @GetMapping(value = "/")
    @ApiOperation(value="Retorna todos os históricos médicos ", response = HistoricoMedico[].class, notes = "O endpoint requer token de autenticação e retorna todos" +
            " os registros de históricos de usuários cadastrados na base de dados.")
    public Flux<HistoricoMedico> getHistoricos(){
        return historicoMedicoService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um histórico médico por ID do histórico", response = HistoricoMedico.class, notes = "O endpoint requer token de autenticação, ID do " +
            "histórico médico como parâmetro e retorna todos os dados do histórico selecionado.")
    public Mono<HistoricoMedico> getHistorico(String id){
        return historicoMedicoService.findById(id);
    }

//  Implementar método
//
//    @GetMapping(value = "/{idUsuario}")
//    @ApiOperation(value="Retorna uma lista de históricos médico por ID do usuário", response = HistoricoMedico.class, notes = "O endpoint requer token de autenticação, ID do " +
//            "usuário como parâmetro e retorna todos os registros de históricos do usuário selecionado.")
//    public Flux<HistoricoMedico> getHistoricosPorUsuario(String idUsuario){
//        return historicoMedicoService.findById(idUsuario);
//    }

// Filtrar

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Salva um histórico médico", response = HistoricoMedicoSendDTO.class, notes = "O endpoint requer token de autenticação. Deve ser passado no body " +
            "da requisição um objeto JSON contendo os dados do histórico médico, todos os campos são obrigatórios.")
    public Mono<HistoricoMedico> postHistorico(@RequestBody HistoricoMedico historico){
        return historicoMedicoService.save(historico);
    }
}
