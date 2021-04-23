package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public final class Denunciado extends Persona {
    @OneToOne /*Un denunciado puede tener una sola información adicional
    por ejemplo si es un Adulto Mayor, Niño, Niña, Enfermo Mental, Población LGTBI, Discapacitado, etc*/
    private InformacionAdicional informacionAdicional;

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
}
