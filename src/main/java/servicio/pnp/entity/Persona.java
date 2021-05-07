package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.sql.Date;

@MappedSuperclass
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*------------------------------------------**/
    @NotEmpty(message = "El campo nombres no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String nombres;
    /*-------------------------------------------**/
    @NotEmpty(message = "El campo apellido paterno no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String apellidoPaterno;
    /*-------------------------------------------**/
    @NotEmpty(message = "El campo apellido paterno no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String apellidoMaterno;
    /*-------------------------------------------**/
    @NotEmpty(message = "El campo sexo no puede quedar vacio")
    @Column(length = 25, nullable = false)
    private String sexo;
    /*-------------------------------------------**/
    @Column(nullable = false)
    private boolean vigencia;
    /*-------------------------------------------**/
    @OneToOne
    private TipoIdentificacion tipoIdentificacion;
    /*--------------------------------------------*/
    @Column(length = 11)
    private String numeroIdentificacion;

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

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isVigencia() {
        return vigencia;
    }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}
