package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Agraviado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*------------------------------------------------*/
    @NotBlank(message = "Debe ingresar el nombre del agraviado")
    @Column(length = 100, nullable = false)
    private String nombreAgraviado;
    /*-------------------------------------------------*/
    @NotBlank(message = "Debe ingresar el apellido del agraviado")
    @Column(length = 100, nullable = false)
    private String apellidosAgraviado;
    /*--------------------------------------------------*/
    @NotBlank(message = "Debe seleccionar el tipo de sexo")
    @Column(length = 1, nullable = false)
    private String sexo;
    /*---------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su fecha de nacimiento")
    @Column(nullable = false)
    private Date fechaNac;
    /*----------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su numero telefonico")
    @Column(length = 9, nullable = false)
    private String telefono;
    /*-----------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su numero de documento")
    @Column(length = 11, nullable = false)
    private String numeroDoc;
    /*-------------------------------------------------*/
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
    /*------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar un tipo de identificación")
    @OneToOne /*Un agraviado un tipo de identificación*/
    private TipoIdentificacion tipoIdentificacion;
    /*-------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar un distrito")
    @OneToOne /*Un agraviado puede residir en un distrito*/
    private Distrito distrito;
    /*--------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar una información Adicional")
    @OneToOne /*Un agraviado puede tener una sola información adicional
    por ejemplo si es un Adulto Mayor, Niño, Niña, Enfermo Mental, Población LGTBI, Discapacitado, etc*/
    private InformacionAdicional informacionAdicional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAgraviado() {
        return nombreAgraviado;
    }

    public void setNombreAgraviado(String nombreAgraviado) {
        this.nombreAgraviado = nombreAgraviado;
    }

    public String getApellidosAgraviado() {
        return apellidosAgraviado;
    }

    public void setApellidosAgraviado(String apellidosAgraviado) {
        this.apellidosAgraviado = apellidosAgraviado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNumeroDoc() {
        return numeroDoc;
    }

    public void setNumeroDoc(String numeroDoc) {
        this.numeroDoc = numeroDoc;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }


    public InformacionAdicional getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(InformacionAdicional informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }


}
