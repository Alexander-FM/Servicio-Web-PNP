package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.Tramites;

public interface TramitesRepository extends CrudRepository<Tramites,Integer> {
    @Query(value = "SELECT T.* FROM tramites T WHERE DATE(T.fecha_denuncia) BETWEEN :fechaI AND :fechaF AND DAYOFWEEK(T.fecha_denuncia)=:diaS",nativeQuery = true)
    Iterable<Tramites> obtenerContadorPorDiadelaSemanaEnunRangoDeFechas(int diaS,String fechaI,String fechaF);

    @Query(value = "SELECT EXISTS(SELECT T.* FROM tramites T WHERE T.cod_tramite=:codtramite)", nativeQuery = true)
    int existsByName(String codtramite);

    @Query(value = "SELECT EXISTS(SELECT T.* FROM tramites T WHERE T.cod_tramite=:codtramite AND NOT (T.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String codtramite, int id);

    @Query("SELECT T FROM Tramites T WHERE T.tipoTramite.id=:idTt")
    Iterable<Tramites> findByTipo(int idTt);

    @Query("SELECT T FROM Tramites T WHERE T.policia.id=:id")
    Iterable<Tramites> findByPolicia(int id);

    @Query("SELECT T FROM Tramites T WHERE T.estadoTramite=:estado")
    Iterable<Tramites> findByEstado(int estado);
}
