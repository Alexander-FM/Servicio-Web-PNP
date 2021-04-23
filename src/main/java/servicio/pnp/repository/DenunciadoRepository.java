package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Denunciado;

import java.util.List;

public interface DenunciadoRepository extends CrudRepository<Denunciado, Integer> {
    @Query(value = "SELECT D.* FROM denunciado D WHERE EXISTS(SELECT DD.* FROM denuncia_denunciado DD WHERE DD.denunciado_id=D.id and DD.denuncia_id=:idD)", nativeQuery = true)
    List<Denunciado> findByDenunciaId(int idD);
}
