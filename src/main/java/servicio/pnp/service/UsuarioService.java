package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Usuario;
import servicio.pnp.repository.UsuarioRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public GenericResponse<Usuario> login(String email, String contrasenia) {
        Optional<Usuario> optU = this.repository.login(email, contrasenia);
        if (optU.isPresent()) {
            return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_OK,OPERACION_CORRECTA,optU.get());
        } else {
            return new GenericResponse<Usuario>(TIPO_AUTH,RPTA_WARNING,OPERACION_INCORRECTA,new Usuario());
        }
    }
}
