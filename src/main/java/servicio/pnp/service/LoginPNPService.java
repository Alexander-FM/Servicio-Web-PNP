package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.GradoPNP;
import servicio.pnp.entity.LoginPNP;
import servicio.pnp.entity.Policia;
import servicio.pnp.repository.LoginPNPRepository;
import servicio.pnp.utils.GenericResponse;
import sun.rmi.runtime.Log;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class LoginPNPService {
    private LoginPNPRepository repository;

    public LoginPNPService(LoginPNPRepository repository) {
        this.repository = repository;
    }
    //LISTAR USUARIO
    public GenericResponse<Iterable<LoginPNP>> listAll() {
        return new GenericResponse<Iterable<LoginPNP>>(OPERACION_CORRECTA, RPTA_OK, "detalle encontrado", this.repository.findAll());
    }

    public GenericResponse login(String codigoPolicial, String clave) {
        GenericResponse response = new GenericResponse();
        response.setType(TIPO_AUTH);

        Optional<LoginPNP> optUsuario = repository.findByCredenciales(codigoPolicial, clave);
        if (optUsuario.isPresent()) {
            response.setRpta(RPTA_OK);
            response.setMessage("Credenciales correctas");
            response.setBody(optUsuario.get());
        } else {
            response.setRpta(RPTA_WARNING);
            response.setMessage("Credenciales Incorrectas o policía inactivo, comuníquese a la central para activar su vigencia. GRACIAS");
            response.setBody(false);
        }
        return response;
    }
    //GUARDAR Y ACTUALIZAR USUARIO
    public GenericResponse save(LoginPNP lp){
        Optional<LoginPNP> opt = this.repository.findById(lp.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if(idf == 0){
            if(repository.existsByName(lp.getCodigoPolicial().trim(), lp.getClave().trim()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un loginPNP con ese mismo código policial y/o clave" );
            }else{
                //GUARDA
                lp.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(lp));
            }
        }else{
            //ACTUALIZAR REGISTRO
            if(repository.existByNameForUpdate(lp.getCodigoPolicial().trim(), lp.getClave().trim(), lp.getId()) == 1){
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        "loginPNP con ese mismo código policial y/o clave");
            }else{
                //ACTUALIZA
                lp.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(lp));
            }
        }
    }
    //DESACTIVAR O ACTIVAR EL ESTADO DEL USUARIO
    public GenericResponse delete(int id) {
        Optional<LoginPNP> opt = this.repository.findById(id);
        LoginPNP usuarioEliminado = null;
        if (opt.isPresent()) {
            //ACTUALIZA EL ESTADO Y GUARDA
            usuarioEliminado = opt.get();
            usuarioEliminado.setEstado(!usuarioEliminado.isEstado());
            this.repository.save(usuarioEliminado);
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, usuarioEliminado);
        } else {
            //EL GRADO PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El usuario que desea eliminar no existe");
        }
    }
    //ELIMINAR USUARIO PARA SIEMPRE
    public GenericResponse deleteforAlways(int id) {
        Optional<LoginPNP> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            this.repository.deleteById(id);
            return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, "Éxito: El usuario se ha eliminado correctamente");
        } else {
            return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "El usuario que desea eliminar no existe");
        }
    }
    //ENCONTRAR USUARIO POR ID
    public GenericResponse find(int id) {
        Optional<LoginPNP> opt = this.repository.findById(id);
        if(opt.isPresent()){
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA,opt.get());
        }else{
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El usuario no existe en la Base de Datos");
        }
    }
}

