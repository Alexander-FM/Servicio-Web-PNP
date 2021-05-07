package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@Entity
public final class Agraviado extends Persona{
    @Column(nullable = false)
    private boolean medidaProteccion;
    /*-------------------------------------------------*/
    @Column(length = 500)
    private String detalleProteccion;
    /*-------------------------------------------------*/
    @Column(length = 100)
    private String juzgado;
    /*-------------------------------------------------*/
    //@NotEmpty(message = "La fecha no puede quedar vacía")
    @Column
    private Date fechaEmision;
    /*---------------------------------------------------------*/
    @Column(nullable = true)
    @JsonFormat (pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date  fechaNacimiento;
    /*--------------------------------------------*/
    //@NotEmpty(message = "Relate los hechos a denunciar, ¿Cómo sucedio?")
    @Column(length = 500, nullable = false)
    private String rhd;
    /*--------------------------------------------------------*/
    //@NotEmpty(message = "Debe seleccionar una información Adicional")
    @OneToOne /*Un agraviado puede tener una sola información adicional
    por ejemplo si es un Adulto Mayor, Niño, Niña, Enfermo Mental, Población LGTBI, Discapacitado, etc*/
    private InformacionAdicional informacionAdicional;
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
    /*--------------------------------------*/
    @Column(length = 500)
    private String direccion;
    /*-------------------------------------------**/

    public boolean isMedidaProteccion() {
        return medidaProteccion;
    }

    public void setMedidaProteccion(boolean medidaProteccion) {
        this.medidaProteccion = medidaProteccion;
    }

    public String getDetalleProteccion() {
        return detalleProteccion;
    }

    public void setDetalleProteccion(String detalleProteccion) {
        this.detalleProteccion = detalleProteccion;
    }

    public String getJuzgado() {
        return juzgado;
    }

    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getRhd() {
        return rhd;
    }

    public void setRhd(String rhd) {
        this.rhd = rhd;
    }

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
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
