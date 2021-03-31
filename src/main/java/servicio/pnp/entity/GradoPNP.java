package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@Entity
public class GradoPNP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*---------------------------------*/
    @NotEmpty (message = "El nombre del grado no puede ser vacia")
    @Column(length = 100, nullable = false)
    private String nombreGrado;
    /*---------------------------------*/
    @Column(nullable = false)
    private boolean vigencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }


}
