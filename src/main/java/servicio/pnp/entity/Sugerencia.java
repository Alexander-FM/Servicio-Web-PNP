package servicio.pnp.entity;

import com.sun.istack.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Sugerencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "No puede quedar vacío.")
    @Column(length = 1000, nullable = false)
    private String comentario;
    @Column(nullable = false)
    private float estrellas;
    @ManyToOne(optional = false)
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(float estrellas) {
        this.estrellas = estrellas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
