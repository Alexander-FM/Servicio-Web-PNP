package servicio.pnp.service;

import org.springframework.stereotype.Service;
import servicio.pnp.entity.Policia;
import servicio.pnp.entity.Sugerencia;
import servicio.pnp.repository.SugerenciaRepository;
import servicio.pnp.utils.GenericResponse;

import javax.transaction.Transactional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class SugerenciaService {
    private final SugerenciaRepository repository;

    public SugerenciaService(SugerenciaRepository repository) {
        this.repository = repository;
    }

    public GenericResponse<Sugerencia> saveSugerencia(Sugerencia s) {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(s));
    }

    public GenericResponse<Iterable<Sugerencia>> listarByIdUsuario(int id) {
        return new GenericResponse<Iterable<Sugerencia>>(OPERACION_CORRECTA,
                RPTA_OK,
                "Sugerencia Encontrada",
                this.repository.findByUsuarioID(id));
    }
}
