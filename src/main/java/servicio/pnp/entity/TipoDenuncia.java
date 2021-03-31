package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Entity
public class TipoDenuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*-------------------------------------------------*/
    @NotEmpty(message = "El tipo denuncia no puede quedar vacio")
    @Column(length = 20, nullable = false)
    private String tipoDenuncia;
    /*--------------------------------------------------*/
    @Column(nullable = false)
    private boolean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(String tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
