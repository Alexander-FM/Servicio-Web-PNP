package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.ComisariasRepository;
import servicio.pnp.utils.GenericResponse;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class ComisariasService {
    private final ComisariasRepository repository;

    public ComisariasService(ComisariasRepository repository) {
        this.repository = repository;
    }

    public GenericResponse listAll(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }
}
