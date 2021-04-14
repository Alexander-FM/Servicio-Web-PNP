package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public final class TipoTramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Debe ingresar un tipo de trámite")
    @Column(length = 50, nullable = false)
    private String tipoTramite;

    //@NotEmpty(message = "Debe ingresar el estado 1 o 0")
    @Column(nullable = false)
    private boolean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(String tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
