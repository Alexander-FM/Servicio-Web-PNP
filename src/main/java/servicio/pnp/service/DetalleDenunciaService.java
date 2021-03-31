package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.DetalleDenuncia;
import servicio.pnp.repository.DetalleDenunciaRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class DetalleDenunciaService {
    private final DetalleDenunciaRepository repository;

    public DetalleDenunciaService(DetalleDenunciaRepository repository) {
        this.repository = repository;
    }
    public GenericResponse<List<DetalleDenuncia>> BuscarDetalle(int idD){
        try{
            Optional<List<DetalleDenuncia>> opt=repository.BuscarDetalle(idD);
            if(opt.isPresent()){
                return new GenericResponse<List<DetalleDenuncia>>(OPERACION_CORRECTA,RPTA_OK,"detalle encontrado", opt.get());
            }else{
                return new GenericResponse<List<DetalleDenuncia>>(OPERACION_INCORRECTA,RPTA_WARNING,"detalle no encontrado",new ArrayList<DetalleDenuncia>());
            }
        }catch(Exception e){
            System.out.print("error del servicio:"+e.getMessage());
        }

        return new GenericResponse<List<DetalleDenuncia>>(OPERACION_INCORRECTA,RPTA_WARNING,"detalle no encontrado",new ArrayList<DetalleDenuncia>());

    }
}
