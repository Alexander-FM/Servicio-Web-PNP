package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.Tramites;

import java.util.Optional;

public interface DenunciaRepository extends CrudRepository<Denuncia, Integer> {
    @Query("SELECT D FROM Denuncia D WHERE D.tipoDenuncia.id=:idTd")
    Iterable<Denuncia> findByTipo(int idTd);

    @Query("SELECT D FROM Denuncia D WHERE D.vinculoParteDenunciada.id=:idVpd")
    Iterable<Denuncia> findByVinculo(int idVpd);

    @Query("SELECT D FROM Denuncia D WHERE D.policia.id=:id")
    Iterable<Denuncia> findByPolicia(int id);

    @Query("SELECT D FROM Denuncia D WHERE D.estadoDenuncia=:ed")
    Iterable<Denuncia> findByEstado(boolean ed);

    @Query(value = "SELECT D.* FROM Denuncia D WHERE  YEAR(DATE(D.fecha_denuncia))=:anio AND MONTH(DATE(D.fecha_denuncia))=:mes", nativeQuery = true)
    Iterable<Denuncia> obtenerContadorPorMesesEnUnAÑoEspecifico(int mes, int anio);

    @Query(value = "SELECT EXISTS(SELECT D.* FROM denuncia D WHERE D.cod_denuncia=:codDenuncia)", nativeQuery = true)
    int existsByName(String codDenuncia);

    @Query(value = "SELECT EXISTS(SELECT D.* FROM denuncia D WHERE D.cod_denuncia=:codDenuncia AND NOT (D.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String codDenuncia, int id);

    @Query("SELECT D FROM Denuncia D WHERE D.usuario.id=:idUsu")
    Iterable<Denuncia> devolverDenuncias(int idUsu);

    @Query("SELECT D FROM Denuncia D WHERE D.cod_denuncia=:cod_denuncia AND D.usuario.id=:idUsu")
    Optional<Denuncia> consultarDenuncia(String cod_denuncia, int idUsu);
}
