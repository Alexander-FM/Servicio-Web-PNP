package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.GradoPNP;
import servicio.pnp.service.GradoPNPService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", allowCredentials = "")
@RequestMapping("api/grado")
@RestController
public class GradoPNPController {

    private GradoPNPService service;

    public GradoPNPController(GradoPNPService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    @GetMapping
    public GenericResponse list() {
        return this.service.list();
    }

    @GetMapping("/todos")
    public GenericResponse listAll() {
        return this.service.listAll();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody GradoPNP g) {
        return this.service.save(g);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody GradoPNP g) {
        g.setId(id);
        return this.service.save(g);
    }

    @GetMapping("/turn/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }

}
