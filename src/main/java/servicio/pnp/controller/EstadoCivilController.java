package servicio.pnp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.service.EstadoCivilService;
import servicio.pnp.utils.GenericResponse;

@RestController
@RequestMapping("api/estadocivil")
public class EstadoCivilController {
    private EstadoCivilService service;

    public EstadoCivilController(EstadoCivilService service) {
        this.service = service;
    }
    @GetMapping
    public GenericResponse list(){
        return this.service.list();
    }
}
