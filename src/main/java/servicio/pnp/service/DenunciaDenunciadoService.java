package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.DenunciaDenunciado;
import servicio.pnp.repository.DenunciaDenunciadoRepository;

import java.util.List;

@Service
@Transactional
public class DenunciaDenunciadoService {
    private final DenunciaDenunciadoRepository repository;

    public DenunciaDenunciadoService(DenunciaDenunciadoRepository repository) {
        this.repository = repository;
    }

    public Iterable<DenunciaDenunciado> findByDenuncia(int idD) {
        return this.repository.findByDenuncia(idD);
    }

    public void save(List<DenunciaDenunciado> dds) {
        repository.saveAll(dds);
    }
}
