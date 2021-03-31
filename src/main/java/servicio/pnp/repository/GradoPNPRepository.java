package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.GradoPNP;

public interface GradoPNPRepository extends CrudRepository<GradoPNP,Integer> {
    //LISTADO DE GRADO PNP ACTIVAS
    @Query("SELECT G FROM GradoPNP G WHERE G.vigencia IS 1")
    Iterable<GradoPNP> listar();

    /*CONSULTA PARA QUE AL MOMENTO DE REGISTRAR UN GRADO VALIDE SI EXISTE UNA YA GUARDADA CN EL MISMO NOMBRE
     RETORNA 1 DE SER POSITIVO,0 EN CASO CONTRARIO
    */
    @Query(value = "SELECT EXISTS(SELECT G.* FROM GradoPNP G WHERE G.nombre_grado=:criterio)", nativeQuery = true)
    int existsByName(String criterio);

    /*CONSULTA PARA QUE AL MOMENTO DE ACTUALIZAR UN GRADO VALIDE SI EXISTE UNA YA GUARDADA CN EL MISMO NOMBRE
     RETORNA 1 DE SER POSITIVO,0 EN CASO CONTRARIO
    */
    @Query(value = "SELECT EXISTS(SELECT G.* FROM GradoPNP G WHERE G.nombre_grado=:criterio AND NOT (G.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, int id);
}
