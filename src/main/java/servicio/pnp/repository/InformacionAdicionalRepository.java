package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.InformacionAdicional;

public interface InformacionAdicionalRepository extends CrudRepository<InformacionAdicional, Integer> {
    @Query("SELECT IA FROM InformacionAdicional IA")
    Iterable<InformacionAdicional> listar();

    @Query(value = "SELECT EXISTS(SELECT IA.* FROM informacion_adicional IA WHERE IA.nombre=:criterio)", nativeQuery = true)
    int existsByName(String criterio);

    @Query(value = "SELECT EXISTS(SELECT IA.* FROM informacion_adicional IA WHERE IA.nombre=:criterio AND NOT (IA.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, int id);
}
