package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import com.apirest.bigdatanasaude.service.historicoMedico.HistoricoMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/historico/medico")
public class HistoricoMedicoController {

    @Autowired
    HistoricoMedicoService historicoMedicoService;

    @GetMapping(value = "/")
    public Flux<HistoricoMedico> getHistoricos(){
        return historicoMedicoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<HistoricoMedico> getHistorico(String id){
        return historicoMedicoService.findById(id);
    }

    @PostMapping(value = "/salvar")
    public Mono<HistoricoMedico> postHistorico(HistoricoMedico historico){
        return historicoMedicoService.save(historico);
    }
}
