package servicio.pnp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import servicio.pnp.entity.GradoPNP;
import servicio.pnp.repository.GradoPNPRepository;
import servicio.pnp.utils.GenericResponse;

import java.util.Optional;

import static servicio.pnp.utils.Global.*;

@Service
@Transactional
public class GradoPNPService {
    private final GradoPNPRepository repository;

    public GradoPNPService(GradoPNPRepository repository) {
        this.repository = repository;
    }

    public GenericResponse list() {
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.listar());
    }
    public GenericResponse listAll(){
        return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.findAll());
    }
    public GenericResponse save(GradoPNP g){
        Optional<GradoPNP> opt = this.repository.findById(g.getId());
        int idf = opt.isPresent() ? opt.get().getId() : 0;
        //NUEVO REGISTRO
        if(idf == 0){
            //Busca grados con el mismo nombre
            if(repository.existsByName(g.getNombreGrado().trim()) == 1){
                //Se encontro un grado con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Lo sentimos: " +
                        "Ya existe un grado con ese mismo nombre" );
            }else{
                //GUARDA
                g.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(g));
            }
        }else{
            //ACTUALIZAR REGISTRO
            //++++++++++++++++++++++
            //BUSCA GRADOS CON EL MISMO NOMBRE
            if(repository.existByNameForUpdate(g.getNombreGrado().trim(), g.getId()) == 1){
                //Se encontro un grado con el mismo nombre
                return new GenericResponse(TIPO_RESULT, RPTA_WARNING, OPERACION_INCORRECTA, "Error: Ya existe un" +
                        "grado con ese mismo nombre");
            }else{
                //ACTUALIZA
                g.setId(idf);
                return new GenericResponse(TIPO_DATA, RPTA_OK, OPERACION_CORRECTA, this.repository.save(g));
            }
        }
    }

    public GenericResponse delete(int id) {
        //BUSCA EL GRADO PNP QUE SE DESEA ELIMINAR
        Optional<GradoPNP> opt = this.repository.findById(id);
        GradoPNP gradoEliminado = null;
        if (opt.isPresent()) {
            //ACTUALIZA EL ESTADO Y GUARDA
            gradoEliminado = opt.get();
            gradoEliminado.setVigencia(!gradoEliminado.isVigencia());
            this.repository.save(gradoEliminado);
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA, gradoEliminado);
        } else {
            //EL GRADO PNP QUE SE DESEABA ELIMINAR NO FUE ENCONTRADA
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El grado PNP que desea eliminar no existe");
        }
    }

    public GenericResponse find(int id) {
        Optional<GradoPNP> opt = this.repository.findById(id);
        if(opt.isPresent()){
            return new GenericResponse(TIPO_RESULT,
                    RPTA_OK,
                    OPERACION_CORRECTA,opt.get());
        }else{
            return new GenericResponse(TIPO_RESULT,
                    RPTA_WARNING,
                    OPERACION_INCORRECTA, "El grado PNP no existe en la Base de Datos");
        }
        }
    }