package com.apirest.bigdatanasaude.service;

import com.apirest.bigdatanasaude.document.HistoricoAtendimento;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoricoAtendimentoService {

    Flux<HistoricoAtendimento> findAll();

    Mono<HistoricoAtendimento> findById(String id);

    Mono<HistoricoAtendimento> save(HistoricoAtendimento historicoAtendimento);
}
