package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.InformacionAdicional;
import servicio.pnp.service.InformacionAdicionalService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

@RequestMapping("api/informacionAdicional")
@RestController
public class InformacionAdicionalController {

    private InformacionAdicionalService service;

    public InformacionAdicionalController(InformacionAdicionalService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }
    @GetMapping
    public GenericResponse list(){
        return this.service.list();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody InformacionAdicional ia){
        return this.service.save(ia);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody InformacionAdicional ia) {
        ia.setId(id);
        return this.service.save(ia);
    }

    @DeleteMapping("/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }
}
