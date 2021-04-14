package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.LoginPNP;
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

    //GUARDAR Y ACTUALIZAR POLICIA
    public GenericResponse save(Policia p) {
        Optional<Policia> opt = this.repository.findById(p.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if (idf == 0) {
            if (repository.existsByName(p.getNombres().trim(), p.getApellidoPaterno().trim(), p.getApellidoMaterno().trim(), p.getNumeroIdentificacion().trim(), p.getTelefono().trim()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un policía con esos mismos datos, intente otra vez, y si el problema persiste comuníquese con soporte técnico.");
            } else {
                //GUARDA
                p.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(p));
            }
        } else {
            //ACTUALIZAR REGISTRO
            if (repository.existByNameForUpdate(p.getNombres().trim(), p.getApellidoPaterno().trim(), p.getApellidoMaterno().trim(), p.getNumeroIdentificacion().trim(), p.getTelefono().trim(), p.getId()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        "policía con esos mismos datos. verifíque e intente de nuevo!.");
            } else {
                //ACTUALIZA
                p.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(p));
            }
        }
    }

    public GenericResponse<Iterable<Policia>> list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listActivos());
    }

}
