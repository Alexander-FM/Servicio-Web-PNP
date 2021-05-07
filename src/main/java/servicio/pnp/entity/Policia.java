package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
public final class Policia extends Persona {
    @OneToOne/*Un policia tiene un solo grado*/
    private GradoPNP gradoPNP;
    private boolean estado;
    @Column(nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaNacimiento;
    /*-------------------------------------------*/
    @Column(length = 9, nullable = false)
    @NotEmpty(message = "No puede quedar vacío el campo de texto")
    private String telefono;
    /*--------------------------------------------*/
    @OneToOne
    private EstadoCivil estadoCivil;
    /*--------------------------------------------*/
    @OneToOne
    private Distrito distrito;
    /*--------------------------------------------*/
    @Column(length = 500)
    private String direccion;
    /*-------------------------------------------**/

    public GradoPNP getGradoPNP() {
        return gradoPNP;
    }

    public void setGradoPNP(GradoPNP gradoPNP) {
        this.gradoPNP = gradoPNP;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
