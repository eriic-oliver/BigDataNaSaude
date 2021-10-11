package com.apirest.bigdatanasaude.repository;

import com.apirest.bigdatanasaude.document.HistoricoMedico;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface HistoricoMedicoRepository extends ReactiveMongoRepository<HistoricoMedico, String> {
}
