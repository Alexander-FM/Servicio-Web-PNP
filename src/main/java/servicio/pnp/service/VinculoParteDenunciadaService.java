package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.VinculoParteDenunciada;
import servicio.pnp.repository.VinculoParteDenunciadaRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class VinculoParteDenunciadaService {

    private final VinculoParteDenunciadaRepository repository;

    public VinculoParteDenunciadaService(VinculoParteDenunciadaRepository repository) {
        this.repository = repository;
    }

    public GenericResponse list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listar());
    }

    public GenericResponse save(VinculoParteDenunciada vpd) {
        Optional<VinculoParteDenunciada> opt = this.repository.findById(vpd.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        if (idf == 0) {
            if (repository.existsByName(vpd.getNombre().trim()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un vínculo parte denunciada con ese mismo nombre");
            } else {
                vpd.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(vpd));
            }
        } else {
            if (repository.existByNameForUpdate(vpd.getNombre().trim(), vpd.getId()) == 1) {
                //Se encontro un grado con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe una" +
                        " información adicional con ese mismo nombre");
            } else {
                vpd.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(vpd));
            }
        }
    }

    public GenericResponse delete(int id) {
        Optional<VinculoParteDenunciada> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            this.repository.deleteById(id);
            return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, "Eliminado correctamente");
        } else {
            //EL GRADO PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "El vínculo que desea eliminar no existe");
        }
    }

    public GenericResponse find(int id) {
        Optional<VinculoParteDenunciada> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El vínculo no existe en la Base de Datos");
        }
    }
}
