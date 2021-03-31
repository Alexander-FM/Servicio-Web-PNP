package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Policia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*-------------------------------------------------*/
    @NotBlank(message = "Debe ingresar el nombre del policia")
    @Column(length = 100, nullable = false)
    private String nombres;
    /*-------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su apellidos del policia")
    @Column(length = 100, nullable = false)
    private String apellidos;
    /*---------------------------------------------------*/
    @NotBlank(message = "Debe seleccionar su género")
    @Column(length = 1, nullable = false)
    private String sexo;
    /*----------------------------------------------------*/
    @NotBlank(message = "Debe ingresar el numero telefonico del policia")
    @Column(length = 9)
    private String telefono;
    /*-----------------------------------------------------*/
    @Column(nullable = false)/*Si es true el policia trabaja si es false el policia esta de vacaciones*/
    private boolean estado;
    /*------------------------------------------------------*/
    @OneToOne/*Un policia trabaja o reside en un distrito*/
    private Distrito distrito;
    /*-------------------------------------------------------*/
    @OneToOne/*Un policia tiene un solo grado*/
    private GradoPNP gradoPNP;
    /*--------------------------------------------------------*/
    @OneToOne/*Un policia tiene una sola identificación (Natural / Juridica)*/
    private TipoIdentificacion tipoIdentificacion;
    /*---------------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su numero de identificacion")
    @Column(length = 11, nullable = false)
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public GradoPNP getGradoPNP() {
        return gradoPNP;
    }

    public void setGradoPNP(GradoPNP gradoPNP) {
        this.gradoPNP = gradoPNP;
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
