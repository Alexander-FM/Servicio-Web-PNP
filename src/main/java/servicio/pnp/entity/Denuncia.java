package servicio.pnp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*----------------------------------------------------*/
    @NotBlank(message = "Debe ingresar la fecha de denuncia")
    @Column(nullable = false)
    private Date fechaDenuncia;
    /*-------------------------------------------------------*/
    @NotBlank(message = "Debe ingresar su dirección de su casa")
    @Column(length = 500, nullable = false)
    private String direccion;
    /*-------------------------------------------------------*/
    @NotBlank(message = "Debe ingresar una referencia de su casa")
    @Column(length = 500, nullable = false)
    private String referenciaDireccion;
    /*--------------------------------------------------------*/
    @NotBlank(message = "No puede quedar vacio la fecha de hechos")
    @Column
    private Date fechaHechos;
    /*-----------------------------------------------------*/
    @Column
    private boolean estadoDenuncia;
    /*----------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar el tipo de denuncia a realizar.")
    @OneToOne
    private TipoDenuncia tipoDenuncia;
    /*------------------------------------------------------*/
    @NotEmpty(message = "Debe seleccionar el distrito dónde ocurrio")
    @OneToOne
    private Distrito distrito;
    /*------------------------------------------------------*/
    @NotEmpty(message = "Especifíque el vínculo con la parte denunciada.")
    @OneToOne
    private VinculoParteDenunciada vinculoParteDenunciada;/*Por ejemplo: si es laboral, familiar, otro.
    lo considero como una tabla a parte para mas a futuro no hacer la base de datos más pesada.*/
    /*--------------------------------------------------*/
    @ManyToOne
    private Policia policia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }


    public boolean isEstadoDenuncia() {
        return estadoDenuncia;
    }

    public void setEstadoDenuncia(boolean estadoDenuncia) {
        this.estadoDenuncia = estadoDenuncia;
    }

    public TipoDenuncia getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
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

    public String getReferenciaDireccion() {
        return referenciaDireccion;
    }

    public void setReferenciaDireccion(String referenciaDireccion) {
        this.referenciaDireccion = referenciaDireccion;
    }

    public Date getFechaHechos() {
        return fechaHechos;
    }

    public void setFechaHechos(Date fechaHechos) {
        this.fechaHechos = fechaHechos;
    }

    public VinculoParteDenunciada getVinculoParteDenunciada() {
        return vinculoParteDenunciada;
    }

    public void setVinculoParteDenunciada(VinculoParteDenunciada vinculoParteDenunciada) {
        this.vinculoParteDenunciada = vinculoParteDenunciada;
    }




}
