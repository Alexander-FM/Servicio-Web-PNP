package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.EstadoCivilRepository;
import servicio.pnp.utils.GenericResponse;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class EstadoCivilService {
private final EstadoCivilRepository repository;

    public EstadoCivilService(EstadoCivilRepository repository) {
        this.repository = repository;
    }
    public GenericResponse list(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }
}
