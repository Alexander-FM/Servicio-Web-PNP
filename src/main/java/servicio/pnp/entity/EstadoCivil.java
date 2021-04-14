package servicio.pnp.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public final class EstadoCivil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*----------------------------------------------------*/
    @NotEmpty(message = "El tipo de estado civil no puede quedar vacio")
    @Column(length = 15, nullable = false)
    private String estadoCivil;
    /*-----------------------------------------------------*/
    @Column(nullable = false)
    private boolean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
