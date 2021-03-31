package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.TipoTramite;

public interface TipoTramiteRepository extends CrudRepository<TipoTramite, Integer> {
    @Query("SELECT TT FROM TipoTramite TT WHERE TT.estado IS 1")
    Iterable<TipoTramite> listar();

    @Query(value = "SELECT EXISTS(SELECT TT.* FROM tipo_tramite TT WHERE TT.tipo_tramite=:criterio)", nativeQuery = true)
    int existsByName(String criterio);

    @Query(value = "SELECT EXISTS(SELECT TT.* FROM tipo_tramite TT WHERE TT.tipo_tramite=:criterio AND NOT (TT.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, int id);
}
