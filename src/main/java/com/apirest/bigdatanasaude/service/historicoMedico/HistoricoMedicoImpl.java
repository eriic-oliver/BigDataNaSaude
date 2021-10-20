package com.apirest.bigdatanasaude.service.historicoMedico;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import com.apirest.bigdatanasaude.repository.HistoricoMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HistoricoMedicoImpl implements HistoricoMedicoService{

    @Autowired
    HistoricoMedicoRepository historicoMedicoRepository;

    @Override
    public Flux<HistoricoMedico> findAll() {
        return historicoMedicoRepository.findAll();
    }

    @Override
    public Mono<HistoricoMedico> findById(String id) {
        return historicoMedicoRepository.findById(id);
    }

    @Override
    public Mono<HistoricoMedico> save(HistoricoMedico historicoMedico) {
        return historicoMedicoRepository.save(historicoMedico);
    }
}
