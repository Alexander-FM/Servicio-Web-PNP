package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.repository.DenunciadoRepository;

@Service
@Transactional
public class DenunciadoService {
private final DenunciadoRepository repository;

    public DenunciadoService(DenunciadoRepository repository) {
        this.repository = repository;
    }
}
