package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.DenunciaDenunciado;

public interface DenunciaDenunciadoRepository extends CrudRepository<DenunciaDenunciado, Integer> {
    @Query("SELECT DD FROM DenunciaDenunciado DD where DD.denuncia.id=:idD")
    Iterable<DenunciaDenunciado> findByDenuncia(int idD);
}
