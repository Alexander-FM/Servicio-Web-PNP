package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public final class Agraviado extends Persona{
    @Column(nullable = false)
    private boolean medidaProteccion;
    /*-------------------------------------------------*/
    @Column(length = 500)
    private String detalleProteccion;
    /*-------------------------------------------------*/
    @Column(length = 100)
    private String Juzgado;
    /*-------------------------------------------------*/
    @NotEmpty(message = "La fecha no puede quedar vacía")
    @Column
    private Date fechaEmision;
    /*---------------------------------------------------------*/
    @NotEmpty(message = "Relate los hechos a denunciar, ¿Cómo sucedio?")
    @Column(length = 500, nullable = false)
    private String RHD;
    /*--------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar una información Adicional")
    @OneToOne /*Un agraviado puede tener una sola información adicional
    por ejemplo si es un Adulto Mayor, Niño, Niña, Enfermo Mental, Población LGTBI, Discapacitado, etc*/
    private InformacionAdicional informacionAdicional;

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
        return Juzgado;
    }

    public void setJuzgado(String juzgado) {
        Juzgado = juzgado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getRHD() {
        return RHD;
    }

    public void setRHD(String RHD) {
        this.RHD = RHD;
    }

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
}
