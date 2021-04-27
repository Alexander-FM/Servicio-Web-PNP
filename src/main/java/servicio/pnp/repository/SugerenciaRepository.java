package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Policia;
import servicio.pnp.entity.Sugerencia;
import servicio.pnp.entity.Usuario;

public interface SugerenciaRepository extends CrudRepository<Sugerencia, Integer> {

    @Query("SELECT S FROM Sugerencia S WHERE S.usuario.id=:idUsuario")
    Iterable<Sugerencia> findByUsuarioID(int idUsuario);
}
