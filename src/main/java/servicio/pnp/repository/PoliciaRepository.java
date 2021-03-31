package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Policia;

import java.util.Optional;

public interface PoliciaRepository extends CrudRepository<Policia,Integer> {
    //@Query("SELECT P FROM Policia P WHERE P.loginPNP.codigoPolicial=:idL")
    //Optional<Policia>findByLogin(String idL);
    @Query(value = "SELECT P.* from policia P WHERE NOT EXISTS(SELECT * FROM loginpnp LP WHERE LP.policia_id=P.id)", nativeQuery = true)
    Iterable<Policia> buscarPoliciaSinLogin();
}
