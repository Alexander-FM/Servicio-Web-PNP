package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.DetalleDenuncia;

import java.util.List;
import java.util.Optional;

public interface DetalleDenunciaRepository extends CrudRepository<DetalleDenuncia,Integer> {
    @Query("SELECT DD FROM DetalleDenuncia DD WHERE DD.denuncia.id=:idD")
    public Optional<List<DetalleDenuncia>> BuscarDetalle(int idD);
}
