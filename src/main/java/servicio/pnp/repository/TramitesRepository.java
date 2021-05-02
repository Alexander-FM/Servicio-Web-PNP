package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Tramite;

import java.util.Optional;

public interface TramitesRepository extends CrudRepository<Tramite, Integer> {
    @Query(value = "SELECT T.* FROM tramite T WHERE DATE(T.fecha_denuncia) BETWEEN :fechaI AND :fechaF AND DAYOFWEEK(T.fecha_denuncia)=:diaS", nativeQuery = true)
    Iterable<Tramite> obtenerContadorPorDiadelaSemanaEnunRangoDeFechas(int diaS, String fechaI, String fechaF);

    @Query(value = "SELECT EXISTS(SELECT T.* FROM tramites T WHERE T.cod_tramite=:codtramite)", nativeQuery = true)
    int existsByName(String codtramite);

    @Query(value = "SELECT EXISTS(SELECT T.* FROM tramite T WHERE T.cod_tramite=:codtramite AND NOT (T.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String codtramite, int id);

    @Query("SELECT T FROM Tramite T WHERE T.tipoTramite.id=:idTt")
    Iterable<Tramite> findByTipo(int idTt);

    @Query("SELECT T FROM Tramite T WHERE T.policia.id=:id")
    Iterable<Tramite> findByPolicia(int id);

    @Query("SELECT T FROM Tramite T WHERE T.estadoTramite=:estado")
    Iterable<Tramite> findByEstado(boolean estado);

    @Query("SELECT T FROM Tramite T WHERE T.usuario.id=:idUsu")
    Iterable<Tramite> devolverTramites(int idUsu);

    @Query("SELECT T FROM Tramite T WHERE T.codTramite=:codTramite AND T.usuario.id=:idUsu")
    Optional<Tramite> consultarTramites(String codTramite, int idUsu);
}
