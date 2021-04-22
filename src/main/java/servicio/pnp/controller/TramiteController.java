package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.TipoTramite;
import servicio.pnp.entity.Tramites;
import servicio.pnp.service.TramiteService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

@RequestMapping("api/tramite")
@RestController
public class TramiteController {
    private final TramiteService service;

    public TramiteController(TramiteService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse<Iterable<Tramites>> list() {
        return service.list();
    }

    @GetMapping("/misTramites/{idUsu}")
    public GenericResponse<Iterable<Tramites>> devolverMisTramites(@PathVariable int idUsu){
        return this.service.devolverTramites(idUsu);
    }

    @GetMapping("reportesemanal")
    public GenericResponse<Map<String, Object>> reporteSemanal() {
        return service.reporteSemanal();
    }

    @PostMapping
    public GenericResponse<Tramites> save(@Valid @RequestBody Tramites t) {
        return service.save(t);
    }

    @PostMapping("registrar")
    public GenericResponse<Tramites> saveTramite(@Valid @RequestBody Tramites t) {
        return service.saveTramite(t);
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Tramites tr) {
        tr.setId(id);
        return this.service.saveTramite(tr);
    }

    @GetMapping("/consultarTramite/{codTramite}/{idUsu}")
    public GenericResponse<Tramites> devolverMisTramites(@PathVariable String codTramite, @PathVariable int idUsu){
        return this.service.consultarTramite(codTramite, idUsu);
    }

    @GetMapping("reportefiltro")
    public GenericResponse<Iterable<Tramites>> reporteFiltro(HttpServletRequest request) {
        return service.generarReporteFiltroTramite(Integer.parseInt(request.getParameter("filtro")),
                Integer.parseInt(request.getParameter("seleccion")), request.getParameter("fechaInicial"), request.getParameter("fechaFinal"));
    }

}
