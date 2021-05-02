package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
public final class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*----------------------------------------------------*/
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaDenuncia;
    @Column(nullable = false)
    @JsonFormat(pattern = "hh:mm:ss")
    private Time horaDenuncia;
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
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyyy")
    private Date fechaHechos;
    @Column(nullable = false)
    @JsonFormat(pattern = "hh:mm:ss")
    private Time horaHechos;
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
    @ManyToOne
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaDenuncia() {
        return fechaDenuncia;
    }

    public void setFechaDenuncia(Date fechaDenuncia) {
        this.fechaDenuncia = fechaDenuncia;
    }

    public Time getHoraDenuncia() {
        return horaDenuncia;
    }

    public void setHoraDenuncia(Time horaDenuncia) {
        this.horaDenuncia = horaDenuncia;
    }

    public String getCod_denuncia() {
        return cod_denuncia;
    }

    public void setCod_denuncia(String cod_denuncia) {
        this.cod_denuncia = cod_denuncia;
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

    public Time getHoraHechos() {
        return horaHechos;
    }

    public void setHoraHechos(Time horaHechos) {
        this.horaHechos = horaHechos;
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

    public VinculoParteDenunciada getVinculoParteDenunciada() {
        return vinculoParteDenunciada;
    }

    public void setVinculoParteDenunciada(VinculoParteDenunciada vinculoParteDenunciada) {
        this.vinculoParteDenunciada = vinculoParteDenunciada;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
