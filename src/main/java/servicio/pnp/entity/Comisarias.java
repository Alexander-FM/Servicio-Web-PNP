package servicio.pnp.entity;

import javax.persistence.*;

@Entity
public class Comisarias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombreComisaria;
    @Column(length = 500, nullable = false)
    private String direccionComisaria;
    @Column(length = 9)
    private String telefonoComisaria;
    @OneToOne
    private Distrito distrito;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComisaria() {
        return nombreComisaria;
    }

    public void setNombreComisaria(String nombreComisaria) {
        this.nombreComisaria = nombreComisaria;
    }

    public String getDireccionComisaria() {
        return direccionComisaria;
    }

    public void setDireccionComisaria(String direccionComisaria) {
        this.direccionComisaria = direccionComisaria;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public String getTelefonoComisaria() {
        return telefonoComisaria;
    }

    public void setTelefonoComisaria(String telefonoComisaria) {
        this.telefonoComisaria = telefonoComisaria;
    }
}
