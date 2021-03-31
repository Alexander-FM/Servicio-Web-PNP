package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Tramites;

public interface TramitesRepository extends CrudRepository<Tramites,Integer> {
    @Query(value = "SELECT T.* FROM tramites T WHERE DATE(T.fecha_denuncia) BETWEEN :fechaI AND :fechaF AND DAYOFWEEK(T.fecha_denuncia)=:diaS",nativeQuery = true)
    Iterable<Tramites> obtenerContadorPorDiadelaSemanaEnunRangoDeFechas(int diaS,String fechaI,String fechaF);
}
