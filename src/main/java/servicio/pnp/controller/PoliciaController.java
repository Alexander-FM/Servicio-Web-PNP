package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.LoginPNP;
import servicio.pnp.entity.Policia;
import servicio.pnp.service.PoliciaService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

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
    public GenericResponse<Iterable<Policia>> listAll() {
        return service.listAll();
    }

    @GetMapping
    public GenericResponse<Iterable<Policia>>list(){
        return service.list();
    }

    @GetMapping("sinLogin")
    public GenericResponse<Iterable<Policia>> buscarPoliciasSinLogin() {
        return service.buscarPoliciasSinLogin();
    }
    @PostMapping()
    public GenericResponse save(@Valid @RequestBody Policia p) {
        return this.service.save(p);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Policia p) {
        p.setId(id);
        return this.service.save(p);
    }
}
