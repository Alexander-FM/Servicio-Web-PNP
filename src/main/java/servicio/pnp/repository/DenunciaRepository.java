package servicio.pnp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Denuncia;

import java.util.Optional;

public interface DenunciaRepository extends CrudRepository<Denuncia, Integer> {
    @Query("SELECT D FROM Denuncia D WHERE D.tipoDenuncia.id=:idTd")
    Iterable<Denuncia> findByTipo(int idTd);

    @Query(value = "SELECT COUNT(*) FROM denuncia WHERE comisarias_id=:idC", nativeQuery = true)
    int devolverDenunciasPorComisaria(int idC);

    @Query(value = "SELECT COUNT(*) FROM denuncia WHERE comisarias_id=:idC AND estado_denuncia=0", nativeQuery = true)
    int devolverDenunciasPendientesPorComisaria(int idC);

    @Query("SELECT D FROM Denuncia D WHERE D.comisarias.id=:idC")
    Iterable<Denuncia> listDenunciasByComisarias(int idC);

    @Query("SELECT D FROM Denuncia D WHERE D.vinculoParteDenunciada.id=:idVpd")
    Iterable<Denuncia> findByVinculo(int idVpd);

    @Query("SELECT D FROM Denuncia D WHERE D.tipoDenuncia.id=:idTd AND D.comisarias.id=:idC")
    Iterable<Denuncia> findByTipoAndComisaria(int idTd, int idC);

    @Query("SELECT D FROM Denuncia D WHERE D.vinculoParteDenunciada.id=:idVpd AND D.comisarias.id=:idC")
    Iterable<Denuncia> findByVinculoAndComisaria(int idVpd, int idC);

    @Query("SELECT D FROM Denuncia D WHERE D.policia.id=:id")
    Iterable<Denuncia> findByPolicia(int id);

    @Query("SELECT D FROM Denuncia D WHERE D.estadoDenuncia=:ed")
    Iterable<Denuncia> findByEstado(boolean ed);

    @Query(value = "SELECT D.* FROM Denuncia D WHERE  YEAR(DATE(D.fecha_denuncia))=:anio AND MONTH(DATE(D.fecha_denuncia))=:mes AND COMISARIAS_ID=:idC", nativeQuery = true)
    Iterable<Denuncia> obtenerContadorPorMesesEnUnAÑoEspecifico(int mes, int anio, int idC);

    @Query(value = "SELECT EXISTS(SELECT D.* FROM denuncia D WHERE D.cod_denuncia=:codDenuncia)", nativeQuery = true)
    int existsByName(String codDenuncia);

    @Query(value = "SELECT EXISTS(SELECT D.* FROM denuncia D WHERE D.cod_denuncia=:codDenuncia AND NOT (D.id=:id))", nativeQuery = true)
    int existByNameForUpdate(String codDenuncia, int id);

    @Query("SELECT D FROM Denuncia D WHERE D.usuario.id=:idUsu")
    Iterable<Denuncia> devolverDenuncias(int idUsu);

    @Query("SELECT D FROM Denuncia D WHERE D.cod_denuncia=:cod_denuncia AND D.usuario.id=:idUsu")
    Optional<Denuncia> consultarDenuncia(String cod_denuncia, int idUsu);
}
