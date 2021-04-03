package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.DistritoRepository;
import servicio.pnp.utils.GenericResponse;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class DistritoService {
    private final DistritoRepository repository;

    public DistritoService(DistritoRepository repository) {
        this.repository = repository;
    }

    public GenericResponse listAll() {
        return new GenericResponse(TIPO_RESULT,
                RPTA_OK,
                OPERACION_CORRECTA, this.repository.findAll());
    }
    public GenericResponse list() {
        return new GenericResponse(TIPO_RESULT,
                RPTA_OK,
                OPERACION_CORRECTA, this.repository.list());
    }
}
