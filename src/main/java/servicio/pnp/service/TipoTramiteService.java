package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.TipoTramite;
import servicio.pnp.repository.TipoTramiteRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class TipoTramiteService {
    private final TipoTramiteRepository repository;

    public TipoTramiteService(TipoTramiteRepository repository) {
        this.repository = repository;
    }

    //Método listar
    public GenericResponse list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listar());
    }

    //Registrar Denuncia
    public GenericResponse save(TipoTramite tt) {
        Optional<TipoTramite> opt = this.repository.findById(tt.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if (idf == 0) {
            //Busca tipo trámite con el mismo nombre
            if (repository.existsByName(tt.getTipoTramite().trim()) == 1) {
                //Se encontro un tipo trámite con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un tipo de trámite con ese mismo nombre");
            } else {
                //GUARDA
                tt.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(tt));
            }
        } else {
            //ACTUALIZAR REGISTRO
            //++++++++++++++++++++++
            //BUSCA TIPOS TRÁMITE CON EL MISMO NOMBRE
            if (repository.existByNameForUpdate(tt.getTipoTramite().trim(), tt.getId()) == 1) {
                //Se encontro un tipo trámite con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        "tipo trámite con ese mismo nombre");
            } else {
                //ACTUALIZA
                tt.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(tt));
            }
        }
    }

    //Eliminar
    public GenericResponse delete(int id) {
        //BUSCA EL TIPO TRAMITE QUE SE DESEA ELIMINAR
        Optional<TipoTramite> opt = this.repository.findById(id);
        TipoTramite tipotramiteeliminado = null;
        if (opt.isPresent()) {
            //ACTUALIZA EL ESTADO Y GUARDA
            tipotramiteeliminado = opt.get();
            tipotramiteeliminado.setEstado(false);
            this.repository.save(tipotramiteeliminado);
            return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, tipotramiteeliminado);
        } else {
            //EL TIPO TRÁMITE PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "El tipo trámite que desea eliminar no existe");
        }
    }

    public GenericResponse listAll() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }

    public GenericResponse find(int id) {
        Optional<TipoTramite> opt = this.repository.findById(id);
        if(opt.isPresent()){
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA,opt.get());
        }else{
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El tipo de trámite no existe en la Base de Datos");
        }
    }
}
