package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.DetalleDenuncia;
import servicio.pnp.entity.Tramites;
import servicio.pnp.service.DenunciaService;
import servicio.pnp.service.DetalleDenunciaService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//@CrossOrigin(origins = "*", allowCredentials = "")
@RequestMapping("api/denuncia")
@RestController
public class DenunciaController {
    private DenunciaService service;
    private DetalleDenunciaService ddService;

    public DenunciaController(DenunciaService service, DetalleDenunciaService ddService) {
        this.service = service;
        this.ddService = ddService;
    }

    @GetMapping
    public GenericResponse<Iterable<Denuncia>> listar() {
        return this.service.listar();
    }

    @GetMapping("/detalle/{idD}")
    public GenericResponse<List<DetalleDenuncia>> BuscarDetalle(@PathVariable int idD) {
        return this.ddService.BuscarDetalle(idD);
    }

    @GetMapping("/reporte")
    public GenericResponse<Map<String, Object>> reporte() {
        return service.reporte();
    }

    @GetMapping("/reporte2")
    public GenericResponse<Map<String, Object>> reporte2() {
        return service.generarReporte2();
    }

    @GetMapping("reportefiltro")
    public GenericResponse<Iterable<Denuncia>> reporteFiltro(HttpServletRequest request) {
        return service.generarReporteFiltro(Integer.parseInt(request.getParameter("filtro")),
                Integer.parseInt(request.getParameter("seleccion")), request.getParameter("fechaInicial"), request.getParameter("fechaFinal"));
    }

    @GetMapping("reporteAnual")
    public GenericResponse<Map<String, Object>> reporteAnual() {
        return service.reporteAnual();
    }

    @PostMapping
    public GenericResponse save(@Valid @RequestBody Denuncia d) {
        return this.service.save(d);
    }

    @PostMapping("registrar")
    public GenericResponse<Tramites> saveDenuncia(@Valid @RequestBody Denuncia d) {
        return service.saveDenuncia(d);
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody Denuncia d) {
        d.setId(id);
        return this.service.saveDenuncia(d);
    }

}
