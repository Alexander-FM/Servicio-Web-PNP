package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.TipoDenuncia;
import servicio.pnp.repository.TipoDenunciaRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class TipoDenunciaService {
    private final TipoDenunciaRepository repository;

    public TipoDenunciaService(TipoDenunciaRepository repository) {
        this.repository = repository;
    }

    public GenericResponse listAll() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }

    //Método listar
    public GenericResponse list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listar());
    }

    //Registrar Denuncia
    public GenericResponse save(TipoDenuncia td) {
        Optional<TipoDenuncia> opt = this.repository.findById(td.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if (idf == 0) {
            //Busca tipoDenuncia con el mismo nombre
            if (repository.existsByName(td.getTipoDenuncia().trim()) == 1) {
                //Se encontro un tipo denuncia con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un tipo de denuncia con ese mismo nombre");
            } else {
                //GUARDA
                td.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(td));
            }
        } else {
            //ACTUALIZAR REGISTRO
            //++++++++++++++++++++++
            //BUSCA TIPOS DENUNCIA CON EL MISMO NOMBRE
            if (repository.existByNameForUpdate(td.getTipoDenuncia().trim(), td.getId()) == 1) {
                //Se encontro un tipo denuncia con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        " tipo denuncia con ese mismo nombre");
            } else {
                //ACTUALIZA
                td.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(td));
            }
        }
    }

    //Eliminar
    public GenericResponse delete(int id) {
        //BUSCA EL TIPO DENUNCIA QUE SE DESEA ELIMINAR
        Optional<TipoDenuncia> opt = this.repository.findById(id);
        TipoDenuncia tipodenunciaeliminado = null;
        if (opt.isPresent()) {
            //ACTUALIZA EL ESTADO Y GUARDA
            tipodenunciaeliminado = opt.get();
            tipodenunciaeliminado.setEstado(false);
            this.repository.save(tipodenunciaeliminado);
            return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, tipodenunciaeliminado);
        } else {
            //EL GRADO PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "El tipo denuncia que desea eliminar no existe");
        }
    }

    public GenericResponse find(int id) {
        Optional<TipoDenuncia> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El tipo de denuncia  no existe en la Base de Datos");
        }
    }
}
