package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.DenunciaAgraviado;

public interface DenunciaAgraviadoRepository extends CrudRepository<DenunciaAgraviado, Integer> {
    @Query("SELECT DA FROM DenunciaAgraviado DA WHERE DA.denuncia.id=:idD")
    Iterable<DenunciaAgraviado> findByDenuncia(int idD);
}
