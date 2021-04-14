package servicio.pnp.exception;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import servicio.pnp.utils.GenericResponse;

import static servicio.pnp.utils.Global.OPERACION_ERRONEA;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(Exception.class)
    public GenericResponse genericException(Exception ex) {
        return new GenericResponse("exception", -1, OPERACION_ERRONEA, ex.getMessage());
    }
}
