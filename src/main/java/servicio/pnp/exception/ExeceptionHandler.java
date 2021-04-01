package servicio.pnp.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import servicio.pnp.utils.GenericResponse;
import servicio.pnp.utils.Global;

public class ExeceptionHandler {
    @ExceptionHandler (Exception.class)
    public GenericResponse genericException(Exception ex) {
        return new GenericResponse("exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
    }
}
