package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Tramite;
import servicio.pnp.service.TramiteService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RequestMapping("api/tramite")
@RestController
public class TramiteController {
    private final TramiteService service;

    public TramiteController(TramiteService service) {
        this.service = service;
    }

    @GetMapping
    public GenericResponse<Iterable<Tramite>> list() {
        return service.list();
    }

    @GetMapping("/porComisaria/{idC}")
    public GenericResponse<Iterable<Tramite>> list(@PathVariable int idC) {
        return service.listarbyComisaria(idC);
    }

    @GetMapping("/misTramites/{idUsu}")
    public GenericResponse<Iterable<Tramite>> devolverMisTramites(@PathVariable int idUsu) {
        return this.service.devolverTramites(idUsu);
    }

    @GetMapping("/listarTotalTramitesPorComisaria/{idC}")
    public GenericResponse<Integer> listarTramitesContadorPorComisaria(@PathVariable int idC) {
        return this.service.listarContadorTramites(idC);
    }

    @GetMapping("reportesemanal/{idC}")
    public GenericResponse<Map<String, Object>> reporteSemanal(@PathVariable int idC) {
        return service.reporteSemanal(idC);
    }

    @PostMapping
    public GenericResponse<Tramite> save(@Valid @RequestBody Tramite t) {
        return service.save(t);
    }

    @PostMapping("registrar")
    public GenericResponse<Tramite> saveTramite(@Valid @RequestBody Tramite t) {
        return service.saveTramite(t);
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Tramite tr) {
        tr.setId(id);
        return this.service.saveTramite(tr);
    }

    @GetMapping("/consultarTramite/{codTramite}/{idUsu}")
    public GenericResponse<Tramite> devolverMisTramites(@PathVariable String codTramite, @PathVariable int idUsu) {
        return this.service.consultarTramite(codTramite, idUsu);
    }

    @GetMapping("reportefiltro")
    public GenericResponse<Iterable<Tramite>> reporteFiltro(HttpServletRequest request) {
        return service.generarReporteFiltroTramite(Integer.parseInt(request.getParameter("filtro")),
                Integer.parseInt(request.getParameter("seleccion")), request.getParameter("fechaInicial"), request.getParameter("fechaFinal"));
    }

    @GetMapping("/listarCTramitesPendientePorComisaria/{idC}")
    public GenericResponse<Integer> listarCTramitesPendientes(@PathVariable int idC) {
        return this.service.listarContadorTramitesPendientes(idC);
    }

}
