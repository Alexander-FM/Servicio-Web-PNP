package servicio.pnp.repository;

import org.springframework.data.repository.CrudRepository;
import servicio.pnp.entity.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento,Integer> {
}
