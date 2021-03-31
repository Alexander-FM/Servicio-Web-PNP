package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*------------------------------------------------*/
    @NotBlank(message = "Debe ingresar un departamento")
    @Column(length = 50, nullable = false)
    private String departamento;
    /*----------------------------------------------*/
    @NotBlank(message = "Debe ingresar una capital")
    @Column(length = 30, nullable = false)
    private String capital;
    /*-----------------------------------------------*/
    @Column(nullable = false)
    private boolean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
