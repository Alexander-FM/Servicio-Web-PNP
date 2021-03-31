package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.VinculoParteDenunciada;
import servicio.pnp.service.VinculoParteDenunciadaService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

@RequestMapping("api/vinculoParteDenunciada")
@RestController
public class VinculoParteDenunciadaController {
    private VinculoParteDenunciadaService service;

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    public VinculoParteDenunciadaController(VinculoParteDenunciadaService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse list() {
        return this.service.list();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody VinculoParteDenunciada vpd) {
        return this.service.save(vpd);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody VinculoParteDenunciada vpd) {
        vpd.setId(id);
        return this.service.save(vpd);
    }

    @DeleteMapping("/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }

}
