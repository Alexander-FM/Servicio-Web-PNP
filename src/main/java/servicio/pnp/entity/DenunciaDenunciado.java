package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public final class DenunciaDenunciado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @JoinColumn(columnDefinition = "fk_DDDenuncia")
    @OneToOne
    @JsonIgnore
    public Denuncia denuncia;
    @OneToOne
    public Denunciado denunciado;

    public DenunciaDenunciado() {
    }

    public DenunciaDenunciado(Denuncia denuncia, Denunciado denunciado) {
        this.denuncia = denuncia;
        this.denunciado = denunciado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public Denunciado getDenunciado() {
        return denunciado;
    }

    public void setDenunciado(Denunciado denunciado) {
        this.denunciado = denunciado;
    }
}
