package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*--------------------------------------------------*/
    @NotBlank(message = "Debe ingresar un distrito")
    @Column(length = 100, nullable = false)
    private String distrito;
    /*--------------------------------------------------*/
    @NotBlank(message = "Debe ingresar un codigo postal")
    @Column(length = 5, nullable = false)
    private String codigoPostal;
    /*--------------------------------------------------*/
    @NotEmpty(message = "Debe ingresar el estado 1 o 0")
    @Column(nullable = false)
    private boolean estado;
    /*-------------------------------------------------*/
    /*-Muchos distritos pertenecen a una provincia*/
    @ManyToOne
    private Provincia provincia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }


}
