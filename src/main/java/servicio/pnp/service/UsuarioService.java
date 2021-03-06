package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.TipoDenuncia;
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
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, OPERACION_CORRECTA, optU.get());
        } else {
            return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_WARNING, OPERACION_INCORRECTA, new Usuario());
        }
    }

    public GenericResponse<Usuario> save(Usuario u) {
        if (this.repository.existByDoc(u.getNumeroIdentificacion()) == 1) {
            return new GenericResponse<Usuario>(TIPO_RESULT, RPTA_WARNING, "ya existe un usuario con el mismo número de identifiación", new Usuario());
        } else if (this.repository.existsByEmail(u.getCorreo()) == 1) {
            return new GenericResponse<Usuario>(TIPO_RESULT, RPTA_WARNING, "este email ya esta asociado a un usuario,pruebe con otro", new Usuario());
        }
        return new GenericResponse<Usuario>(TIPO_AUTH, RPTA_OK, OPERACION_CORRECTA, this.repository.save(u));
    }

    public GenericResponse<Boolean> existsByEmail(String email) {
        return new GenericResponse(TIPO_RESULT, RPTA_OK, OPERACION_CORRECTA, this.repository.existsByEmail(email) == 1);
    }

    public GenericResponse<Usuario> changePassword(String email, String pass){
        Optional<Usuario> optUsuario = repository.findByEmail(email);
        if (optUsuario.isPresent()){
            Usuario usu = optUsuario.get();
            usu.setContraseña(pass);
            return new GenericResponse<Usuario>(TIPO_RESULT,
                    RPTA_OK,
                    "Contraseña cambiada, vuelve a iniciar sesión",
                    this.repository.save(usu));
        }
        return new GenericResponse(TIPO_RESULT, RPTA_ERROR, OPERACION_ERRONEA, new Usuario());
    }
}
