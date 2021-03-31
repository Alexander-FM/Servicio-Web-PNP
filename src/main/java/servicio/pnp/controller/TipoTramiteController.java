package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.TipoTramite;
import servicio.pnp.service.TipoTramiteService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

@RequestMapping("api/tipoTramite")
@RestController
public class TipoTramiteController {

    private TipoTramiteService service;

    public TipoTramiteController(TipoTramiteService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }
    @GetMapping("todos")
    public GenericResponse listAll() {
        return this.service.listAll();
    }

    @GetMapping
    public GenericResponse list() {
        return this.service.list();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody TipoTramite tt) {
        return this.service.save(tt);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody TipoTramite tt) {
        tt.setId(id);
        return this.service.save(tt);
    }

    @DeleteMapping("/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }
}
