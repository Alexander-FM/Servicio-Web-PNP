package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.email=:email AND U.contrasenia=:contrasenia")
    Optional<Usuario>login(String email,String contrasenia);

    @Query(value = "(SELECT EXISTS(SELECT id  FROM Usuario WHERE email=:email))", nativeQuery = true)
    int existsByEmail(String email);

    @Query(value = "(SELECT EXISTS(SELECT id FROM Usuario WHERE numero_identificacion=:ni))", nativeQuery = true)
    int existByDoc(String ni);
}
