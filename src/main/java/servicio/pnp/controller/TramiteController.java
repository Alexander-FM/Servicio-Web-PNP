package servicio.pnp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.pnp.entity.Tramites;
import servicio.pnp.service.TramiteService;
import servicio.pnp.utils.GenericResponse;

import java.util.Map;

@RequestMapping("api/tramite")
@RestController
public class TramiteController {
    private TramiteService service;

    public TramiteController(TramiteService service) {
        this.service = service;
    }
    @GetMapping
    public GenericResponse<Iterable<Tramites>>list(){
        return service.list();
    }
    @GetMapping("reportesemanal")
    public GenericResponse<Map<String,Object>>reporteSemanal(){
        return service.reporteSemanal();
    }
}
