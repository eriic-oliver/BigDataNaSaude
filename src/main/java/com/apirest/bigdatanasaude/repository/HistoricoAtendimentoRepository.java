package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.HistoricoAtendimento;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HistoricoAtendimentoRepository extends ReactiveMongoRepository<HistoricoAtendimento, String> {
}
