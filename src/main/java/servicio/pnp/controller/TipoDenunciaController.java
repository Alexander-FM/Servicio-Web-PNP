package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.TipoDenuncia;
import servicio.pnp.service.TipoDenunciaService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

@RequestMapping("api/tipoDenuncia")
@RestController
public class TipoDenunciaController {

    private TipoDenunciaService service;

    public TipoDenunciaController(TipoDenunciaService service) {
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
    public GenericResponse save(@Valid @RequestBody TipoDenuncia td) {
        return this.service.save(td);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody TipoDenuncia td) {
        td.setId(id);
        return this.service.save(td);
    }

    @DeleteMapping("/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }
}
