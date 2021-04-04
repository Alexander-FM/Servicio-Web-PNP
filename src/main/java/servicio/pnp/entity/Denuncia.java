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
    @Column(nullable = false)
    private Date fechaDenuncia;
    /*---------------------------------------------------*/
    @Column(length = 8)/*POR EJEMPLO: D-3423-P
    S-> Sexual, P-> Psicológica, E-> Económica, F-> Familiar*/
    private String cod_denuncia;
    /*-------------------------------------------------------*/
    @Column(length = 500, nullable = false)
    private String direccion;
    /*-------------------------------------------------------*/
    @Column(length = 500, nullable = false)
    private String referenciaDireccion;
    /*--------------------------------------------------------*/
    @Column
    private Date fechaHechos;
    /*-----------------------------------------------------*/
    @Column
    private boolean estadoDenuncia;
    /*----------------------------------------------------*/
    @OneToOne
    private TipoDenuncia tipoDenuncia;
    /*------------------------------------------------------*/
    @OneToOne
    private Distrito distrito;
    /*------------------------------------------------------*/
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

    public String getCod_denuncia() {
        return cod_denuncia;
    }

    public void setCod_denuncia(String cod_denuncia) {
        this.cod_denuncia = cod_denuncia;
    }
}
