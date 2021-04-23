package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Agraviado;

import java.util.List;

public interface AgraviadoRepository extends CrudRepository<Agraviado, Integer> {
    @Query(value = "SELECT A.* FROM agraviado A WHERE EXISTS(SELECT DA.* FROM denuncia_agraviado DA WHERE DA.agraviado_id=A.id AND DA.denuncia_id=:idD)", nativeQuery = true)
    List<Agraviado> findByDenunciaId(int idD);
}
