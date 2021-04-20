package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.DenunciaAgraviado;
import servicio.pnp.repository.DenunciaAgraviadoRepository;

import java.util.Collection;

@Service
@Transactional
public class DenunciaAgraviadoService {
    private final DenunciaAgraviadoRepository repository;

    public DenunciaAgraviadoService(DenunciaAgraviadoRepository repository) {
        this.repository = repository;
    }
    public Iterable<DenunciaAgraviado>findByDenuncia(int idD){
        return this.repository.findByDenuncia(idD);
    }
    public void save(Collection<DenunciaAgraviado> da){
        repository.saveAll(da);
    }
}
