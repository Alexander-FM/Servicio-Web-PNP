package servicio.pnp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.entity.Usuario;
import servicio.pnp.service.UsuarioService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;

//@CrossOrigin(origins = "*",allowCredentials = "")
@RequestMapping("api/usuario")
@RestController
public class LoginController {
    private UsuarioService service;

    public LoginController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("contrasenia");
        return this.service.login(email,contrasenia);
    }
}
