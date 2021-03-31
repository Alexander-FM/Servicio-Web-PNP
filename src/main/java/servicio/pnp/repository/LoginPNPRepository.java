package servicio.pnp.repository;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.LoginPNP;

import java.util.Optional;

public interface LoginPNPRepository extends CrudRepository<LoginPNP,Integer> {
    @Query("SELECT L FROM LoginPNP L WHERE L.codigoPolicial=:codigoPolicial AND L.clave=:clave AND L.estado IS 1")
    Optional<LoginPNP> findByCredenciales(String codigoPolicial, String clave);
    @Query(value = "SELECT EXISTS(SELECT LP.* FROM loginpnp LP WHERE LP.codigo_policial=:criterio AND LP.clave=:clave)", nativeQuery = true)
    int existsByName(String criterio, String clave);
    @Query(value = "SELECT EXISTS(SELECT LP.* FROM loginpnp LP WHERE LP.codigo_policial=:criterio AND LP.clave=:clave AND NOT (LP.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, String clave, int id);
}
