package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.VinculoParteDenunciada;


public interface VinculoParteDenunciadaRepository extends CrudRepository<VinculoParteDenunciada,Integer> {
    @Query("SELECT VPD FROM VinculoParteDenunciada VPD")
    Iterable<VinculoParteDenunciada> listar();

    @Query(value = "SELECT EXISTS(SELECT VPD.* FROM vinculo_parte_denunciada VPD WHERE VPD.nombre=:criterio)", nativeQuery = true)
    int existsByName(String criterio);

    @Query(value = "SELECT EXISTS(SELECT VPD.* FROM vinculo_parte_denunciada VPD WHERE VPD.nombre=:criterio AND NOT (VPD.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String criterio, int id);
}
