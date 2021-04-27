package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.Sugerencia;
import servicio.pnp.entity.dto.DenunciaConDetallesDTO;
import servicio.pnp.service.SugerenciaService;
import servicio.pnp.utils.GenericResponse;

import javax.validation.Valid;

@RequestMapping("api/sugerencia")
@RestController
public class SugerenciaController {
    private final SugerenciaService service;

    public SugerenciaController(SugerenciaService service) {
        this.service = service;
    }

    @GetMapping("/byUsuario/{id}")
    public GenericResponse<Iterable<Sugerencia>> listar(@PathVariable int id) {
        return this.service.listarByIdUsuario(id);
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody Sugerencia s) {
        return this.service.saveSugerencia(s);
    }
}
