package servicio.pnp.controller;

import servicio.pnp.entity.GradoPNP;
import servicio.pnp.entity.LoginPNP;
import servicio.pnp.entity.Policia;
import servicio.pnp.service.LoginPNPService;
import servicio.pnp.utils.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@CrossOrigin(origins = "*", allowCredentials = "")
@RequestMapping("api/LoginPnp")
@RestController
public class LoginPNPController {
    private LoginPNPService service;

    public LoginPNPController(LoginPNPService service) {
        this.service = service;
    }

    @PostMapping
    public GenericResponse login(@RequestBody Credenciales c) {

        return this.service.login(c.getCp(), c.getCl());
    }

    @GetMapping("usuarios")
    public GenericResponse<Iterable<LoginPNP>> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public GenericResponse find(@PathVariable int id) {
        return this.service.find(id);
    }

    @PostMapping("registrar")
    public GenericResponse save(@Valid @RequestBody LoginPNP lp) {
        return this.service.save(lp);
    }

    @PutMapping("/{id}")
    public GenericResponse update(@PathVariable int id, @Valid @RequestBody LoginPNP lp) {
        lp.setId(id);
        return this.service.save(lp);
    }

    @GetMapping("/turn/{id}")
    public GenericResponse delete(@PathVariable int id) {
        return this.service.delete(id);
    }

    @DeleteMapping("/{id}")
    public GenericResponse deleteforAlways(@PathVariable int id) {
        return this.service.deleteforAlways(id);
    }


}
