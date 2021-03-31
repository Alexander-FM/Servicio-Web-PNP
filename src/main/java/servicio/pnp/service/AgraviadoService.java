package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Agraviado;
import servicio.pnp.repository.AgraviadoRepository;
import servicio.pnp.utils.GenericResponse;
import java.util.Optional;

import static servicio.pnp.utils.Global.*;
@Service
@Transactional
public class AgraviadoService {
    private final AgraviadoRepository repository;

    public AgraviadoService(AgraviadoRepository repository) {
        this.repository = repository;
    }
    public GenericResponse save(Agraviado a){
return new GenericResponse(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,this.repository.save(a));
    }
}
