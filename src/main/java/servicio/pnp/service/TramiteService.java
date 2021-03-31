package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.Tramites;
import servicio.pnp.repository.TramitesRepository;
import servicio.pnp.utils.GenericResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class TramiteService {
    private final TramitesRepository repository;


    public TramiteService(TramitesRepository repository) {
        this.repository = repository;
    }

    public GenericResponse<Map<String, Object>> reporteSemanal() {
        Map<String, Object> data = new HashMap<>();
        data.put("estaSemana", reporteS(false));
        data.put("semanaPasada", reporteS(true));
        return new GenericResponse<>(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, data);
    }

    public GenericResponse<Iterable<Tramites>> list() {
        return new GenericResponse<>(TIPO_DATA,RPTA_OK,OPERACION_CORRECTA,repository.findAll());
    }

    public List<Integer> reporteS(boolean semanaPasada) {
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
            data.add(((List<Tramites>) repository.obtenerContadorPorDiadelaSemanaEnunRangoDeFechas(i, fechaInicialS, fechaFinalS)).size());
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
}
