package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.TipoDenuncia;

public interface TipoDenunciaRepository extends CrudRepository<TipoDenuncia,Integer> {
    @Query("SELECT TD FROM TipoDenuncia TD WHERE TD.estado IS 1")
    Iterable<TipoDenuncia> listar();

    @Query(value = "SELECT EXISTS(SELECT TD.* FROM tipo_denuncia TD WHERE TD.tipo_denuncia=:criterio)", nativeQuery = true)
    int existsByName(String criterio);

    @Query(value = "SELECT EXISTS(SELECT TD.* FROM tipo_denuncia TD WHERE TD.tipo_denuncia=:criterio AND NOT (TD.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, int id);
}
