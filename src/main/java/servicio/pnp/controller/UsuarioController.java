package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Usuario;
import servicio.pnp.service.UsuarioService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//@CrossOrigin(origins = "*",allowCredentials = "")
@RequestMapping("api/usuario")
@RestController
public class UsuarioController {
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public GenericResponse<Usuario> login(HttpServletRequest request) {
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("contrasenia");
        return this.service.login(email,contrasenia);
    }
    @PostMapping
    public GenericResponse<Usuario> save(@Valid @RequestBody Usuario u) {
        return this.service.save(u);
    }
}