package servicio.pnp.controller.socket;

import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import servicio.pnp.entity.Tramite;

@Controller
public class TramitesSocketController {
    @SendTo("/topic/tramite-noti")
    public Tramite notif(Tramite response) {
        return response;
    }
}
