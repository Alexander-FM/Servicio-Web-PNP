package servicio.pnp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.service.DistritoService;
import servicio.pnp.utils.GenericResponse;

@RequestMapping("api/distrito")
@RestController
public class DistritoController {
    private DistritoService service;

    public DistritoController(DistritoService service) {
        this.service = service;
    }
    @GetMapping("todos")
    public GenericResponse listAll(){
        return this.service.listAll();
    }
}
