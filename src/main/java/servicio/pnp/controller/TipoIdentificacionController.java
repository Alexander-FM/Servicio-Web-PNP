package servicio.pnp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.service.TipoIdentificacionService;
import servicio.pnp.utils.GenericResponse;

@RequestMapping("api/tipoIdentificacion")
@RestController
public class TipoIdentificacionController {
    private TipoIdentificacionService service;

    public TipoIdentificacionController(TipoIdentificacionService service) {
        this.service = service;
    }

    @GetMapping("todos")
    public GenericResponse listAll() {
        return this.service.listAll();
    }

    @GetMapping
    public GenericResponse list() {
        return this.service.list();
    }
}
