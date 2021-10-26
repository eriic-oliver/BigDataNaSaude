package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.HistoricoAtendimento;
import com.apirest.bigdatanasaude.document.User;
import com.apirest.bigdatanasaude.model.HistoricoAtendimentoSendDTO;
import com.apirest.bigdatanasaude.model.HistoricoMedicoSendDTO;
import com.apirest.bigdatanasaude.service.historicoAtendimento.HistoricoAtendimentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/historico/atendimento")
@Api(value="API REST - Histórico de Atendimento", tags = "Histórico de Atendimento", description = "Métodos relacionados a históricos de atendimento")
@CrossOrigin(origins = "*")
public class HistoricoAtendimentoController {

    @Autowired
    HistoricoAtendimentoService historicoAtendimentoService;

    @GetMapping(value = "/")
    @ApiOperation(value="Retorna todos os usuários", response = HistoricoAtendimento[].class, notes = "O endpoint requer token de autenticação e retorna todos" +
            " os registros de históricos de atendimentos cadastrados na base de dados.")
    public Flux<HistoricoAtendimento> getHistoricos(){
        return historicoAtendimentoService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value="Retorna um histórico de atendimento por Id do histórico", response = HistoricoAtendimento.class, notes = "O endpoint requer token de " +
            "autenticação, ID do histórico de atendimento como parâmetro e retorna todos os dados do histórico selecionado.")
    public Mono<HistoricoAtendimento> getHistorico(String id){
        return historicoAtendimentoService.findById(id);
    }

//  Implementar método
//
//    @GetMapping(value = "/{idUsuario}")
//    @ApiOperation(value="Retorna uma lista de históricos de atendimentos por Id do usuário", response = HistoricoAtendimento.class, notes = "O endpoint requer token de " +
//            "autenticação, ID do usuário como parâmetro e retorna todos os registros de histórico do usuário selecionado.")
//    public Flux<HistoricoAtendimento> getHistoricosPorUsuario(String idUsuario){
//        return historicoAtendimentoService.findById(idUsuario);
//    }

// Filtrar

    @PostMapping(value = "/salvar")
    @ApiOperation(value="Salva um histórico de atendimento", response = HistoricoAtendimentoSendDTO.class, notes = "O endpoint requer token de autenticação. " +
            "Deve ser passado no body da requisição um objeto JSON contendo os dados do histórico de atendimento, todos os campos são obrigatórios.")
    public Mono<HistoricoAtendimento> postHistorico(@RequestBody HistoricoAtendimento historico){
        return historicoAtendimentoService.save(historico);
    }
}
