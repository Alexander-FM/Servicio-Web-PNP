package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.TipoIdentificacionRepository;

@Service
@Transactional
public class TipoIdentificacionService {
private final TipoIdentificacionRepository repository;

    public TipoIdentificacionService(TipoIdentificacionRepository repository) {
        this.repository = repository;
    }
}
