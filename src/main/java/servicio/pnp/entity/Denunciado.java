package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Denunciado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*-------------------------------------------------*/
    @NotBlank(message = "Debe ingresar sus nombres del denunciado")
    @Column(length = 100)
    private String nombres;
    /*--------------------------------------------------*/
    @NotBlank(message = "Debe ingresar sus apellidos del denunciado")
    @Column(length = 100)
    private String apellidos;
    /*---------------------------------------------------*/
    @NotBlank(message = "Debe seleccionar su género")
    @Column(length = 1)
    private String sexo;
    /*---------------------------------------------------*/
    @NotBlank(message = "Debe ingresar ingresar la dirección del denunciado")
    @Column(length = 500)
    private String direccion;
    /*-----------------------------------------------------*/
    @NotBlank(message = "Indique su numero de identificación")
    @Column(length = 11)
    private String numeroIdentificacion;
    /*------------------------------------------------------*/
    @NotBlank(message = "Ingrese su numero telefonico")
    @Column(length = 9)
    private String telefono;
    /*------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar su estado civil.")
    @OneToOne
    private EstadoCivil estadoCivil;
    /*------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar el distrito donde reside")
    @OneToOne
    private Distrito distrito;
    /*-------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar si es una persona natural o jurídica.")
    @OneToOne
    private TipoIdentificacion tipoIdentificacion;
    /*--------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar información adicional.")
    @OneToOne /*Un denunciado puede tener una sola información adicional
    por ejemplo si es un Adulto Mayor, Niño, Niña, Enfermo Mental, Población LGTBI, Discapacitado, etc*/
    private InformacionAdicional informacionAdicional;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
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

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }
}
