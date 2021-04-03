package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Distrito;

public interface DistritoRepository extends CrudRepository<Distrito,Integer> {
    @Query("SELECT D FROM Distrito D WHERE D.estado=1")
    Iterable<Distrito> list();
}
