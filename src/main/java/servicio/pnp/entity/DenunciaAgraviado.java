package servicio.pnp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public final class DenunciaAgraviado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @JoinColumn(columnDefinition = "fk_DADenuncia")
    @OneToOne
    @JsonIgnore
    public Denuncia denuncia;
    @OneToOne
    public Agraviado agraviado;

    public DenunciaAgraviado() {
    }

    public DenunciaAgraviado(Denuncia denuncia, Agraviado agraviado) {
        this.denuncia = denuncia;
        this.agraviado = agraviado;
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

    public Agraviado getAgraviado() {
        return agraviado;
    }

    public void setAgraviado(Agraviado agraviado) {
        this.agraviado = agraviado;
    }
}
