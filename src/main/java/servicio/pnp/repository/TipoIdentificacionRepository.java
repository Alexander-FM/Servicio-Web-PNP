package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Distrito;
import servicio.pnp.entity.TipoIdentificacion;

public interface TipoIdentificacionRepository extends CrudRepository<TipoIdentificacion,Integer> {
    @Query("SELECT TI FROM TipoIdentificacion TI WHERE TI.estado=1")
    Iterable<TipoIdentificacion> list();
}
