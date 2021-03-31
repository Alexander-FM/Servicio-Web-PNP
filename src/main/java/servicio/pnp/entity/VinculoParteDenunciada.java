package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class VinculoParteDenunciada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*--------------------------------------------*/
    @NotBlank(message = "Este campo no puede quedar vacio")
    @Column(length = 20, nullable = false)
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
