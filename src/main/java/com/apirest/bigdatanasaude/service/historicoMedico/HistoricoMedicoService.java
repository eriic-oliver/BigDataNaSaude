package com.apirest.bigdatanasaude.service.historicoMedico;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HistoricoMedicoService {

    Flux<HistoricoMedico> findAll();

    Mono<HistoricoMedico> findById(String id);

    Mono<HistoricoMedico> save(HistoricoMedico historicoMedico);
}
