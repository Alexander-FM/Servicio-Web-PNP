package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
    @Query("SELECT U FROM Usuario U WHERE U.correo=:correo AND U.contraseña=:contraseña")
    Optional<Usuario>login(String correo,String contraseña);

    @Query(value = "(SELECT EXISTS(SELECT id  FROM Usuario WHERE correo=:correo))", nativeQuery = true)
    int existsByEmail(String correo);

    @Query(value = "(SELECT EXISTS(SELECT id FROM Usuario WHERE numero_identificacion=:ni))", nativeQuery = true)
    int existByDoc(String ni);

    @Query("SELECT U FROM Usuario U WHERE U.correo=:email")
    Optional<Usuario> findByEmail(String email);
}
