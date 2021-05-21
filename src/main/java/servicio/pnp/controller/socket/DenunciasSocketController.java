package servicio.pnp.controller.socket;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import servicio.pnp.entity.Denuncia;
import servicio.pnp.entity.dto.DenunciaConDetallesDTO;
import servicio.pnp.utils.GenericResponse;

@Controller
public class DenunciasSocketController {
    @SendTo("/topic/denuncia-noti")
    public DenunciaConDetallesDTO notif(DenunciaConDetallesDTO response) {
        return response;
    }
}
