package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Policia;
import servicio.pnp.service.PoliciaService;
import servicio.pnp.utils.GenericResponse;

//@CrossOrigin(origins = "*", allowCredentials = "")
@RestController
@RequestMapping("/api/policia")
public class PoliciaController {
    private PoliciaService service;

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    public PoliciaController(PoliciaService service) {
        this.service = service;
    }

    @GetMapping("todos")
    public GenericResponse<Iterable<Policia>> list() {
        return service.listAll();
    }

    @GetMapping("sinLogin")
    public GenericResponse<Iterable<Policia>> buscarPoliciasSinLogin() {
        return service.buscarPoliciasSinLogin();
    }
}
