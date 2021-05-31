package servicio.pnp.repository;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.LoginPNP;
import servicio.pnp.entity.Usuario;

import java.util.Optional;

public interface LoginPNPRepository extends CrudRepository<LoginPNP,Integer> {
    @Query(value="SELECT L FROM LoginPNP L WHERE L.codigoPolicial=:codigoPolicial AND L.clave=:clave AND L.estado=1")
    Optional<LoginPNP> findByCredenciales(String codigoPolicial, String clave);
    @Query(value = "SELECT EXISTS(SELECT LP.* FROM loginpnp LP WHERE LP.codigo_policial=:criterio AND LP.clave=:clave)", nativeQuery = true)
    int existsByName(String criterio, String clave);
    @Query(value = "SELECT EXISTS(SELECT LP.* FROM loginpnp LP WHERE LP.codigo_policial=:criterio AND LP.clave=:clave AND NOT (LP.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, String clave, int id);

    @Query(value = "(SELECT EXISTS(SELECT id  FROM loginpnp WHERE codigo_policial=:cp))", nativeQuery = true)
    int existsByCp(String cp);

    @Query("SELECT LP FROM LoginPNP LP WHERE LP.codigoPolicial=:codigoP")
    Optional<LoginPNP> findByCodigoPolicial(String codigoP);
}
