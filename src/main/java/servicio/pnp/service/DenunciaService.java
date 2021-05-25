package servicio.pnp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.*;
import servicio.pnp.entity.dto.DenunciaConDetallesDTO;
import servicio.pnp.repository.*;
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
    private final DenunciaAgraviadoService daService;
    private final DenunciaDenunciadoService ddService;
    private final AgraviadoRepository aRepository;
    private final DenunciadoRepository dRepository;
    private final ComisariasRepository cRepository;
    @Autowired
    SimpMessagingTemplate template;

    public DenunciaService(DenunciaRepository repository,
                           TipoDenunciaRepository tdRepository,
                           VinculoParteDenunciadaRepository vpdRepository,
                           DenunciaAgraviadoService daService,
                           DenunciaDenunciadoService ddService,
                           AgraviadoRepository aRepository,
                           ComisariasRepository cRepository,
                           DenunciadoRepository dRepository) {
        this.repository = repository;
        this.tdRepository = tdRepository;
        this.vpdRepository = vpdRepository;
        this.daService = daService;
        this.ddService = ddService;
        this.aRepository = aRepository;
        this.dRepository = dRepository;
        this.cRepository = cRepository;

    }

    public GenericResponse<Iterable<Denuncia>> listar() {
        return new GenericResponse<Iterable<Denuncia>>(OPERACION_CORRECTA, RPTA_OK, "detalle encontrado", this.repository.findAll());
    }

    public GenericResponse<List<DenunciaConDetallesDTO>> devolvermisDenuncias(int idUsu) {
        final List<DenunciaConDetallesDTO> dtos = new ArrayList<>();
        final Iterable<Denuncia> denuncias = repository.devolverDenuncias(idUsu);
        denuncias.forEach(d -> {
            dtos.add(new DenunciaConDetallesDTO(d, aRepository.findByDenunciaId(d.getId()), dRepository.findByDenunciaId(d.getId())));
        });
        return new GenericResponse(OPERACION_CORRECTA, RPTA_OK, "Todo muy bien", dtos);
    }

    public GenericResponse<DenunciaConDetallesDTO> consultarDenuncia(String codDenuncia, int idUsu) {
        final DenunciaConDetallesDTO dto;
        final Denuncia d = repository.consultarDenuncia(codDenuncia, idUsu).orElse(new Denuncia());
        dto = new DenunciaConDetallesDTO(d, aRepository.findByDenunciaId(d.getId()), dRepository.findByDenunciaId(d.getId()));
        return new GenericResponse(OPERACION_CORRECTA, RPTA_OK, "Todo muy bien", dto);
    }

    public GenericResponse<Map<String, Object>> getDetalles(int idD) {
        Map<String, Object> detalles = new HashMap<>();
        detalles.put("agraviados", daService.findByDenuncia(idD));
        detalles.put("denunciados", ddService.findByDenuncia(idD));
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, detalles);
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
                    denuncias = repository.findByEstado(seleccion == 1);
                    break;
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

    public GenericResponse save(final DenunciaConDetallesDTO dto) {
        Date date = new Date();
        dto.getDenuncia().setFechaDenuncia(new java.sql.Date(date.getTime()));
        dto.getDenuncia().setHoraDenuncia(new java.sql.Time(date.getTime()));
        this.repository.save(dto.getDenuncia());

        final Iterable<Agraviado> agraviados = this.aRepository.saveAll(dto.getAgraviados());
        final Iterable<Denunciado> denunciados = this.dRepository.saveAll(dto.getDenunciados());
        final List<DenunciaAgraviado> das = new ArrayList<>();
        final List<DenunciaDenunciado> dds = new ArrayList<>();

        for (Agraviado a : agraviados) {
            das.add(new DenunciaAgraviado(dto.getDenuncia(), a));
        }
        for (Denunciado d : denunciados) {
            dds.add(new DenunciaDenunciado(dto.getDenuncia(), d));
        }
        daService.save(das);
        ddService.save(dds);
        template.convertAndSend("/topic/denuncia-noti", dto);
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, "denuncia guardada correctamente");
    }

    public GenericResponse saveDenuncia(Denuncia d) {
        Optional<Denuncia> opt = this.repository.findById(d.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if (idf == 0) {
            if (repository.existsByName(d.getCod_denuncia().trim()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe una denuncia con ese mismo código denuncia");
            } else {
                d.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(d));
            }
        } else {
            if (repository.existByNameForUpdate(d.getCod_denuncia().trim(), d.getId()) == 1) {
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe una" +
                        " denuncia con ese mismo código de denuncia, intente otra vez!");
            } else {
                //ACTUALIZA
                d.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(d));
            }
        }
    }

    public GenericResponse find(int id) {
        Optional<Denuncia> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "La Denuncia no existe en la Base de Datos");
        }
    }
}
