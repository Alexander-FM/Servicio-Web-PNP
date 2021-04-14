package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.utils.GenericResponse;

import java.util.List;

@Service
@Transactional
public class DetalleDenunciaService {
    public GenericResponse<List<Object>> BuscarDetalles(int idD){
      return null;
    }
}
