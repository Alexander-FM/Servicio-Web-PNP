package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*-------------------------------------------*/
    @NotBlank(message = "Debe ingresar su número de identificación")
    @Column(length = 11, nullable = false)
    private String numeroIdentificacion;
    /*------------------------------------------*/
    @NotEmpty(message = "El campo nombres no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String nombres;
    /*-------------------------------------------*/
    @NotEmpty(message = "El campo apellido paterno no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String apellidoPaterno;
    /*-------------------------------------------*/
    @NotEmpty(message = "El campo apellido paterno no puede quedar vacio")
    @Column(length = 100, nullable = false)
    private String apellidoMaterno;
    /*--------------------------------------------*/
    @Column(nullable = false)
    private Date fechaNacimiento;
    /*-------------------------------------------*/
    @NotEmpty(message = "El campo sexo no puede quedar vacio")
    @Column(length = 1, nullable = false)
    private String sexo;
    /*-------------------------------------------*/
    @Column(nullable = false)
    private boolean vigencia;
    /*-------------------------------------------*/
    @Column(length = 9,nullable = false)
    @NotEmpty(message = "No puede quedar vacío el campo de texto")
    private String telefono;
    /*-------------------------------------------*/
    @Email(message = "Ingrese un email válido!")
    @Column(length = 100, nullable = false)
    private String email;
    /*-------------------------------------------*/
    @NotEmpty(message = "La contraseña no puede quedar vacia!")
    @Column(length = 20, nullable = false)
    private String contrasenia;
    /*-------------------------------------------*/
    @OneToOne
    private TipoIdentificacion tipoIdentificacion;
    /*--------------------------------------------*/
    @OneToOne
    private EstadoCivil estadoCivil;
    /*--------------------------------------------*/
    @OneToOne
    private Distrito distrito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
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
}
