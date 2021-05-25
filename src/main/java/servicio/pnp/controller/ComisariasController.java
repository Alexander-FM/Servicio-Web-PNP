package servicio.pnp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.service.ComisariasService;
import servicio.pnp.utils.GenericResponse;

@RestController
@RequestMapping("api/comisarias")
public class ComisariasController {
    private ComisariasService service;

    public ComisariasController(ComisariasService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse listAll() {
        return this.service.listAll();
    }
}
