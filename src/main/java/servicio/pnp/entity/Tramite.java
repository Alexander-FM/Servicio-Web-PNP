package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public final class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*--------------------------------------*/
    @Column(length = 6)
    private String codTramite;/*Una vez ingresado el trámite la mayor dará el cod-trámite por correo del usuario*/
    /*--------------------------------------*/
    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy",timezone = "America/Lima")
    private Date fechaTramite;/*Se rellenará automaticamente*/
    @Column(nullable = false)
    @JsonFormat(pattern = "hh:mm:ss")
    private Time horaTramite;
    /*--------------------------------------*/
    @OneToOne
    private TipoTramite tipoTramite;/*El usuario selecciona el tipo de trámite.*/
    /*--------------------------------------*/
    @Column(nullable = false)
    private boolean estadoTramite;/*por defecto se mandará en 0 como pendiente y 1 si es diligenciada, mejor dicho que ya
    está siendo atendido su trámite.*/
    /*--------------------------------------*/
    @ManyToOne
    private Usuario usuario;/*Representa en este caso el denunciante. Con la sesion del usuario podemos capturar todos
    sus datos personales.*/
    @ManyToOne
    private Policia policia; /*Muchos Trámites puede atender un solo policía*/

    @Column(length = 256)
    private String correo;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodTramite() {
        return codTramite;
    }

    public void setCodTramite(String codTramite) {
        this.codTramite = codTramite;
    }

    public Date getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public Time getHoraTramite() {
        return horaTramite;
    }

    public void setHoraTramite(Time horaTramite) {
        this.horaTramite = horaTramite;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public boolean isEstadoTramite() {
        return estadoTramite;
    }

    public void setEstadoTramite(boolean estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Policia getPolicia() {
        return policia;
    }

    public void setPolicia(Policia policia) {
        this.policia = policia;
    }
}
