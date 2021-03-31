package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*-------------------------------------------------*/
    @NotBlank(message = "Debe ingresar una provincia")
    @Column(length = 100, nullable = false)
    private String provincia;
    /*-------------------------------------------------*/
    @Column(nullable = false)
    private boolean estado;

    /*-Muchas Provincia pertenecen un departamento-*/
    @ManyToOne
    private Departamento departamento;

    /*La parte izquierda hace referencia a la clase actual y la parte derecha a la clase destino quedaría de la siguiente
    * manera Muchas provincias pertenecen a un departamento.*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


}
