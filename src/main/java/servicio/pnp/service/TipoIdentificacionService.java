package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.TipoIdentificacionRepository;
import servicio.pnp.utils.GenericResponse;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class TipoIdentificacionService {
    private final TipoIdentificacionRepository repository;

    public TipoIdentificacionService(TipoIdentificacionRepository repository) {
        this.repository = repository;
    }

    public GenericResponse list() {
        return new GenericResponse(TIPO_RESULT,
                RPTA_OK,
                OPERACION_CORRECTA, this.repository.list());
    }

    public GenericResponse listAll(){
        return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }
}
