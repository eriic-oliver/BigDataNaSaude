package com.apirest.bigdatanasaude.controller;

import com.apirest.bigdatanasaude.document.HistoricoAtendimento;
import com.apirest.bigdatanasaude.service.historicoAtendimento.HistoricoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api/historico/atendimento")
public class HistoricoAtendimentoController {

    @Autowired
    HistoricoAtendimentoService historicoAtendimentoService;

    @GetMapping(value = "/")
    public Flux<HistoricoAtendimento> getHistoricos(){
        return historicoAtendimentoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<HistoricoAtendimento> getHistorico(String id){
        return historicoAtendimentoService.findById(id);
    }

    @PostMapping(value = "/salvar")
    public Mono<HistoricoAtendimento> postHistorico(HistoricoAtendimento historico){
        return historicoAtendimentoService.save(historico);
    }
}
