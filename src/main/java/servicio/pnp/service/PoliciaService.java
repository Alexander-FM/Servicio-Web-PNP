package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Policia;
import servicio.pnp.repository.PoliciaRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class PoliciaService {
    private final PoliciaRepository repository;

    public PoliciaService(PoliciaRepository repository) {
        this.repository = repository;
    }

    public GenericResponse<Iterable<Policia>> listAll() {
        return new GenericResponse<Iterable<Policia>>(OPERACION_CORRECTA, RPTA_OK, "detalle encontrado", this.repository.findAll());
    }


    public GenericResponse find(int id) {
        Optional<Policia> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El Policia no existe en la Base de Datos");
        }
    }

    public GenericResponse buscarPoliciasSinLogin() {
        return new GenericResponse(TIPO_RESULT,
                RPTA_OK,
                OPERACION_CORRECTA, this.repository.buscarPoliciaSinLogin());
    }
}
