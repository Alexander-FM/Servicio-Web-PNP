package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.EstadoCivilRepository;

@Service
@Transactional
public class EstadoCivilService {
private final EstadoCivilRepository repository;

    public EstadoCivilService(EstadoCivilRepository repository) {
        this.repository = repository;
    }
}
