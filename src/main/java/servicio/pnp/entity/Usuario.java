package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
public final class Usuario extends Persona {
    @NotBlank
    private String correo;
    @NotBlank
    private String contraseña;

    @Column(nullable = true)
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fechaNacimiento;
    @Column(length = 9, nullable = false)
    @NotEmpty(message = "No puede quedar vacío el campo de texto")
    private String telefono;
    /*--------------------------------------------*/
    @OneToOne
    private EstadoCivil estadoCivil;
    /*--------------------------------------------*/
    @OneToOne
    private Distrito distrito;
    /*----------------------------------------------*/
    @Column(length = 500)
    private String direccion;
    /*-------------------------------------------**/

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
