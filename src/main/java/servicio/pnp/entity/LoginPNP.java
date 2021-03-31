package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class LoginPNP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*------------------------------------------------*/
    @NotEmpty(message = "El codigo policial no puede quedar vacio ni nulo")
    @Column(length = 10, nullable = false)
    private String codigoPolicial;
    /*-------------------------------------------------*/
    @NotEmpty(message = "La clave no puede quedar vacia")
    @Column(length = 50, nullable = false)
    private String clave;
    /*-------------------------------------------------*/
    @Column(nullable = false)
    private boolean estado;
    /*-------------------------------------------------*/
    @OneToOne
    private Policia policia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoPolicial() {
        return codigoPolicial;
    }

    public void setCodigoPolicial(String codigoPolicial) {
        this.codigoPolicial = codigoPolicial;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }
}
