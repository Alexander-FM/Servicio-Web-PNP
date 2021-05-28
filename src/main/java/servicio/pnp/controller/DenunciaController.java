package servicio.pnp.controller;

import org.springframework.web.bind.annotation.*;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.dto.DenunciaConDetallesDTO;
import servicio.pnp.service.DenunciaService;
import servicio.pnp.service.DetalleDenunciaService;
import servicio.pnp.utils.GenericResponse;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

@RequestMapping("api/denuncia")
@RestController
public class DenunciaController {
    private DenunciaService service;
    private DetalleDenunciaService ddService;

    public DenunciaController(DenunciaService service, DetalleDenunciaService ddService) {
        this.service = service;
        this.ddService = ddService;
    }

    @GetMapping("/porComisaria/{idC}")
    public GenericResponse<Iterable<Denuncia>> listar(@PathVariable int idC) {
        return this.service.listar(idC);
    }

    @GetMapping("/listarTotalDenunciasPorComisaria/{idC}")
    public GenericResponse<Integer> listarDenunciasContadorPorComisaria(@PathVariable int idC) {
        return this.service.listarContadorDenuncias(idC);
    }

    @GetMapping("/listarCDenunciasPendientePorComisaria/{idC}")
    public GenericResponse<Integer> listarCDenunciasPendientes(@PathVariable int idC) {
        return this.service.listarContadorDenunciasPendientes(idC);
    }

    @GetMapping("/misDenuncias/{idUsu}")
    public GenericResponse devolverMisDenuncias(@PathVariable int idUsu) {
        return this.service.devolvermisDenuncias(idUsu);
    }

    @GetMapping("/detalle/{idD}")
    public GenericResponse BuscarDetalles(@PathVariable int idD) {
        return service.getDetalles(idD);
    }

    @GetMapping("/reporte")
    public GenericResponse<Map<String, Object>> reporte() {
        return service.reporte();
    }

    @GetMapping("/reporte2/{idC}")
    public GenericResponse<Map<String, Object>> reporte2(@PathVariable int idC) {
        return service.generarReporte2(idC);
    }

    @GetMapping("reportefiltro")
    public GenericResponse<Iterable<Denuncia>> reporteFiltro(HttpServletRequest request) {
        return service.generarReporteFiltro(Integer.parseInt(request.getParameter("filtro")),
                Integer.parseInt(request.getParameter("seleccion")), request.getParameter("fechaInicial"), request.getParameter("fechaFinal"));
    }

    @GetMapping("reporteAnual/{idC}")
    public GenericResponse<Map<String, Object>> reporteAnual(@PathVariable int idC) {
        return service.reporteAnual(idC);
    }

    @PostMapping
    public GenericResponse save(@RequestBody DenunciaConDetallesDTO d) {
        return this.service.save(d);
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

    @GetMapping("/consultarDenuncia/{cod_denuncia}/{idUsu}")
    public GenericResponse consultarDenuncia(@PathVariable String cod_denuncia, @PathVariable int idUsu) {
        return this.service.consultarDenuncia(cod_denuncia, idUsu);
    }

}
