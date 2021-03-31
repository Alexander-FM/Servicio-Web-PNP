package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.TipoDenuncia;
import servicio.pnp.entity.VinculoParteDenunciada;
import servicio.pnp.repository.DenunciaRepository;
import servicio.pnp.repository.TipoDenunciaRepository;
import servicio.pnp.repository.VinculoParteDenunciadaRepository;
import servicio.pnp.utils.GenericResponse;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class DenunciaService {
    private final DenunciaRepository repository;
    private final TipoDenunciaRepository tdRepository;
    private final VinculoParteDenunciadaRepository vpdRepository;

    public DenunciaService(DenunciaRepository repository, TipoDenunciaRepository tdRepository, VinculoParteDenunciadaRepository vpdRepository) {
        this.repository = repository;
        this.tdRepository = tdRepository;
        this.vpdRepository = vpdRepository;
    }

    public GenericResponse<Iterable<Denuncia>> listar() {
        return new GenericResponse<Iterable<Denuncia>>(OPERACION_CORRECTA, RPTA_OK, "detalle encontrado", this.repository.findAll());
    }

    public GenericResponse<Map<String, Object>> reporte() {
        Map<String, Object> data = new HashMap<>();
        Iterable<TipoDenuncia> tiposDenuncia = tdRepository.findAll();

        data.put("tipos", tiposDenuncia);
        List<Integer> contador = new ArrayList<>();
        List<String> tipos = new ArrayList<>();
        for (TipoDenuncia td : tiposDenuncia) {
            tipos.add(td.getTipoDenuncia());
            Iterable<Denuncia> denuncias = repository.findByTipo(td.getId());
            contador.add(((List<Denuncia>) denuncias).size());
        }
        data.put("tipos", tipos);
        data.put("contador", contador);
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, data);
    }

    public GenericResponse<Map<String, Object>> generarReporte2() {

        Map<String, Object> data = new HashMap<>();
        data.put("tipo", reportePorTipos());
        data.put("vinculo", reportePorVinculo());
        return new GenericResponse(TIPO_AUTH, RPTA_OK, OPERACION_CORRECTA, data);
    }

    private Map<String, Object> reportePorTipos() {
        Iterable<TipoDenuncia> tiposDenuncia = tdRepository.findAll();
        List<String> tipos = new ArrayList<>();
        List<Integer> contador = new ArrayList<>();
        for (TipoDenuncia td : tiposDenuncia) {
            tipos.add(td.getTipoDenuncia());
            Iterable<Denuncia> denuncias = repository.findByTipo(td.getId());
            contador.add(((List<Denuncia>) denuncias).size());
        }
        Map<String, Object> porTipos = new HashMap<>();
        porTipos.put("tipos", tipos);
        porTipos.put("contadores", contador);
        return porTipos;
    }

    private Map<String, Object> reportePorVinculo() {
        Iterable<VinculoParteDenunciada> vinculosDenuncia = vpdRepository.findAll();
        List<String> vinculos = new ArrayList<>();
        List<Integer> contador = new ArrayList<>();
        for (VinculoParteDenunciada vpd : vinculosDenuncia) {
            vinculos.add(vpd.getNombre());
            Iterable<Denuncia> denuncias = repository.findByVinculo(vpd.getId());
            contador.add(((List<Denuncia>) denuncias).size());
        }
        Map<String, Object> porVinculo = new HashMap<>();
        porVinculo.put("vinculos", vinculos);
        porVinculo.put("contadores", contador);
        return porVinculo;
    }


    public GenericResponse<Iterable<Denuncia>> generarReporteFiltro(int filtro, int seleccion, String fechaRangoInicial, String fechaRangoFinal) {
        Iterable<Denuncia> denuncias = null;
        try {
            switch (filtro) {
                case 1:
                    denuncias = repository.findByTipo(seleccion);
                    break;
                case 2:
                    denuncias = repository.findByVinculo(seleccion);
                    break;
                case 3:
                    denuncias = repository.findByPolicia(seleccion);
                    break;
                case 4:
                    denuncias = repository.findByEstado(seleccion);
            }
            if (!fechaRangoInicial.equals("") && !fechaRangoFinal.equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaInicial = sdf.parse(fechaRangoInicial), fechaFinal = sdf.parse(fechaRangoFinal);
                List<Denuncia> denunciasFiltradas = new ArrayList<>();
                for (Denuncia d : denuncias) {
                    if (!d.getFechaDenuncia().before(fechaInicial) && !d.getFechaDenuncia().after(fechaFinal)) {
                        denunciasFiltradas.add(d);
                    }
                }
                return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, denunciasFiltradas);
            }
            return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, denuncias);
        } catch (Exception e) {
            System.out.println("error al generar reporte:" + e.getMessage());
        }
        return null;
    }

    public GenericResponse<Map<String, Object>> reporteAnual() {
        Map<String, Object> data = new HashMap<>();
        data.put("esteAño", reporteA(false));
        data.put("añoPasado", reporteA(true));
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, data);
    }

    private Object reporteA(boolean añoPasado) {
        LocalDateTime ldt = LocalDateTime.now();
        final Calendar actualCalendar = GregorianCalendar.from(ZonedDateTime.of(ldt, ZoneId.systemDefault()));
        if (añoPasado) {
            Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            Calendar c = new GregorianCalendar();
            c.setTime(date);
            c.add(Calendar.YEAR, -1);
            ldt = c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {

            data.add((((List<Denuncia>) repository.obtenerContadorPorMesesEnUnAÑoEspecifico(i, ldt.getYear())).size()));
        }
        return data;
    }
}
