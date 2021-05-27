package servicio.pnp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Tramite;
import servicio.pnp.entity.dto.DenunciaConDetallesDTO;
import servicio.pnp.repository.DenunciaRepository;
import servicio.pnp.repository.TramitesRepository;
import servicio.pnp.utils.GenericResponse;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class TramiteService {
    @Autowired
    SimpMessagingTemplate template;
    private final TramitesRepository repository;

    public TramiteService(TramitesRepository repository, DenunciaRepository dRepository) {
        this.repository = repository;
    }

    public GenericResponse<Map<String, Object>> reporteSemanal(int idC) {
        Map<String, Object> data = new HashMap<>();
        data.put("estaSemana", reporteS(false, idC));
        data.put("semanaPasada", reporteS(true, idC));
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, data);
    }

    public GenericResponse<Iterable<Tramite>> list() {
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, repository.findAll());
    }

    public GenericResponse<Iterable<Tramite>> devolverTramites(int idUsu) {
        return new GenericResponse<Iterable<Tramite>>(OPERACION_CORRECTA, RPTA_OK, "Todo muy bien", this.repository.devolverTramites(idUsu));
    }

    public GenericResponse<Tramite> consultarTramite(String codTramite, int idUsu) {
        return new GenericResponse<Tramite>(OPERACION_CORRECTA, RPTA_OK, "Todo muy bien",
                this.repository.consultarTramites(codTramite, idUsu).orElse(new Tramite()));
    }

    public GenericResponse saveTramite(Tramite tr) {
        Date date = new Date();
        tr.setFechaTramite(new java.sql.Date(date.getTime()));
        tr.setHoraTramite(new java.sql.Time(date.getTime()));
        Optional<Tramite> opt = this.repository.findById(tr.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if (idf == 0) {
            if (repository.existsByName(tr.getCodTramite().trim()) == 1) {
                //Se encontro un tipo denuncia con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un trámite con ese mismo código trámite");
            } else {
                //GUARDA
                tr.setId(idf);
                template.convertAndSend("/topic/tramite-noti", tr);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(tr));
            }
        } else {
            if (repository.existByNameForUpdate(tr.getCodTramite().trim(), tr.getId()) == 1) {
                //Se encontro un tipo denuncia con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        " trámite con ese mismo código de trámite, intente otra vez!");
            } else {
                //ACTUALIZA
                tr.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(tr));
            }
        }
    }

    public GenericResponse find(int id) {
        Optional<Tramite> opt = this.repository.findById(id);
        if (opt.isPresent()) {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, opt.get());
        } else {
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El Trámite no existe en la Base de Datos");
        }
    }

    public List<Integer> reporteS(boolean semanaPasada, int idC) {
        String fechaInicialS = "", fechaFinalS = "";
        LocalDateTime ldt = LocalDateTime.now();
        final Calendar actualCalendar = GregorianCalendar.from(ZonedDateTime.of(ldt, ZoneId.systemDefault()));
        if (semanaPasada) {
            Date date = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
            Calendar c = new GregorianCalendar();
            c.setTime(date);
            c.add(Calendar.DAY_OF_YEAR, -7);
            ldt = c.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        }
        final int diaSemana = actualCalendar.get(Calendar.DAY_OF_WEEK);
        final Calendar fi = GregorianCalendar.from(ZonedDateTime.of(ldt, ZoneId.systemDefault()));
        final Calendar ff = GregorianCalendar.from(ZonedDateTime.of(ldt, ZoneId.systemDefault()));
        switch (diaSemana) {
            case 1:
                asignarCalendar(fi, ff, 0, 6);
                break;
            case 2:
                asignarCalendar(fi, ff, -1, 5);
                break;
            case 3:
                asignarCalendar(fi, ff, -2, 4);
                break;
            case 4:
                asignarCalendar(fi, ff, -3, 3);
                break;
            case 5:
                asignarCalendar(fi, ff, -4, 2);
                break;
            case 6:
                asignarCalendar(fi, ff, -5, 1);
                break;
            case 7:
                asignarCalendar(fi, ff, -6, 0);
                break;
        }
        fechaInicialS = armarFechaDesdeCalendar(fi);
        fechaFinalS = armarFechaDesdeCalendar(ff);
        List<Integer> data = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            data.add(((List<Tramite>) repository.obtenerContadorPorDiadelaSemanaEnunRangoDeFechas(i, fechaInicialS, fechaFinalS, idC)).size());
        }
        return data;
    }

    private String armarFechaDesdeCalendar(Calendar c) {
        String fecha = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.DAY_OF_MONTH);
        return fecha;
    }

    private void asignarCalendar(Calendar fi, Calendar ff, int addI, int addF) {
        fi.add(Calendar.DAY_OF_YEAR, addI);
        ff.add(Calendar.DAY_OF_YEAR, addF);
    }

    public GenericResponse<Tramite> save(Tramite t) {
        template.convertAndSend("/topic/tramite-noti", t);
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(t));
    }

    public GenericResponse<Iterable<Tramite>> generarReporteFiltroTramite(int filtro, int seleccion, String fechaRangoInicial, String fechaRangoFinal) {
        Iterable<Tramite> tramites = null;
        try {
            switch (filtro) {
                case 1:
                    tramites = repository.findByTipo(seleccion);
                    break;
                case 2:
                    tramites = repository.findByPolicia(seleccion);
                    break;
                case 3:
                    tramites = repository.findByEstado(seleccion == 1);
                    break;
            }
            if (!fechaRangoInicial.equals("") && !fechaRangoFinal.equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaInicial = sdf.parse(fechaRangoInicial), fechaFinal = sdf.parse(fechaRangoFinal);
                List<Tramite> tramitesFiltrados = new ArrayList<>();
                for (Tramite d : tramites) {
                    if (!d.getFechaTramite().before(fechaInicial) && !d.getFechaTramite().after(fechaFinal)) {
                        tramitesFiltrados.add(d);
                    }
                }
                return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, tramitesFiltrados);
            }
            return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, tramites);
        } catch (Exception e) {
            System.out.println("error al generar reporte:" + e.getMessage());
        }
        return null;
    }


}
