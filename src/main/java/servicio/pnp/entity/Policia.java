package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public final class Policia extends Persona {
    @OneToOne/*Un policia tiene un solo grado*/
    private GradoPNP gradoPNP;
    private boolean estado;

    public GradoPNP getGradoPNP() {
        return gradoPNP;
    }

    public void setGradoPNP(GradoPNP gradoPNP) {
        this.gradoPNP = gradoPNP;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
