package com.apirest.bigdatanasaude.service.historicoAtendimento;

import com.apirest.bigdatanasaude.document.HistoricoAtendimento;
import com.apirest.bigdatanasaude.repository.HistoricoAtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HistoricoAtendimentoImpl implements HistoricoAtendimentoService{

    @Autowired
    HistoricoAtendimentoRepository historicoAtendimentoRepository;

    @Override
    public Flux<HistoricoAtendimento> findAll() {
        return historicoAtendimentoRepository.findAll();
    }

    @Override
    public Mono<HistoricoAtendimento> findById(String id) {
        return historicoAtendimentoRepository.findById(id);
    }

    @Override
    public Mono<HistoricoAtendimento> save(HistoricoAtendimento historicoAtendimento) {
        return historicoAtendimentoRepository.save(historicoAtendimento);
    }

    @Override
    public Flux<HistoricoAtendimento> findByIdUsuario(String id) {
        Flux<HistoricoAtendimento> flux = historicoAtendimentoRepository.findAll().filter(his ->
                his.getIdUsuario().equals(id)
        );
        return flux;
    }

    @Override
    public Flux<HistoricoAtendimento> findByFilterMedico(String filterMedico) {
        Flux<HistoricoAtendimento> flux = historicoAtendimentoRepository.findAll().filter(his ->
                his.getMedico().equals(filterMedico)
        );
        return flux;
    }

}
