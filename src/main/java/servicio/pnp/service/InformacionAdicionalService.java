package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.GradoPNP;
import servicio.pnp.entity.InformacionAdicional;
import servicio.pnp.repository.InformacionAdicionalRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class InformacionAdicionalService {

    private final InformacionAdicionalRepository repository;

    public InformacionAdicionalService(InformacionAdicionalRepository repository) {
        this.repository = repository;
    }

    public GenericResponse list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listar());
    }

    public GenericResponse save(InformacionAdicional ia) {
        Optional<InformacionAdicional> opt = this.repository.findById(ia.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if (idf == 0) {
            if (repository.existsByName(ia.getNombre().trim()) == 1) {
                //Se encontro un grado con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe una información adicional con ese mismo nombre");
            } else {
                ia.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(ia));
            }
        } else {
            //ACTUALIZAR REGISTRO
            //++++++++++++++++++++++
            //BUSCA GRADOS CON EL MISMO NOMBRE
            if (repository.existByNameForUpdate(ia.getNombre().trim(), ia.getId()) == 1) {
                //Se encontro un grado con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe una" +
                        " información adicional con ese mismo nombre");
            } else {
                //ACTUALIZA
                ia.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(ia));
            }
        }
    }

    public GenericResponse delete(int id) {
        Optional<InformacionAdicional> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            this.repository.deleteById(id);
            return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, "Eliminado correctamente");
        } else {
            //EL GRADO PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "La información adicional que desea eliminar no existe");
        }
    }

    public GenericResponse find(int id) {
        Optional<InformacionAdicional> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "La información adicional no existe en la Base de Datos");
        }
    }
}


