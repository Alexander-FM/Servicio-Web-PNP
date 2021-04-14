package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Policia;

import java.util.Optional;

public interface PoliciaRepository extends CrudRepository<Policia, Integer> {
    //@Query("SELECT P FROM Policia P WHERE P.loginPNP.codigoPolicial=:idL")
    //Optional<Policia>findByLogin(String idL);
    @Query(value = "SELECT P.* from policia P WHERE NOT EXISTS(SELECT * FROM loginpnp LP WHERE LP.policia_id=P.id)", nativeQuery = true)
    Iterable<Policia> buscarPoliciaSinLogin();

    @Query(value = "SELECT EXISTS(SELECT P.* FROM policia P WHERE P.nombres=:nombresP AND P.apellido_paterno=:apellidoP AND P.apellido_materno=:apellidoM AND P.numero_identificacion=:dniP AND P.telefono=:telefonoP)", nativeQuery = true)
    int existsByName(String nombresP, String apellidoP,String apellidoM,String dniP, String telefonoP);

    @Query(value = "SELECT EXISTS(SELECT P.* FROM policia P WHERE P.nombres=:nombresP AND P.apellido_paterno=:apellidoP AND P.apellido_materno=:apellidoM AND P.numero_identificacion=:dniP AND P.telefono=:telefonoP AND NOT (P.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String nombresP, String apellidoP,String apellidoM, String dniP, String telefonoP, int id);

    @Query("SELECT P FROM Policia P WHERE P.estado=1")
    Iterable<Policia> listActivos();
}
