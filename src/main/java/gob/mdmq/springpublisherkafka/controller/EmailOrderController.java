package gob.mdmq.springpublisherkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import gob.mdmq.springpublisherkafka.model.BodyCorreo;
import gob.mdmq.springpublisherkafka.model.Correo;
import gob.mdmq.springpublisherkafka.service.EmailOrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/send-email")
public class EmailOrderController {

    private final EmailOrderService emailOrderService;

    @Autowired
    public EmailOrderController(EmailOrderService emailOrderService) {
        this.emailOrderService = emailOrderService;
    }

    @PostMapping
    public String createEmailOrder(@RequestBody BodyCorreo emailBody) throws JsonProcessingException {
        Correo email;

        log.info("Create email recived {}", emailBody.getDestinatarios().get(1));

        for (int i = 0; i < emailBody.getDestinatarios().size(); i++) {
            log.info(emailBody.getDestinatarios().get(i));
            emailOrderService
                    .createEmailOrder(email = new Correo(emailBody.getIdSistema(), emailBody.getRemitente(), emailBody.getDestinatarios().get(i),
                            emailBody.getAsunto(), emailBody.getMensaje(), emailBody.getAdjunto()));
        }

        // return foodOrderService.createFoodOrder(email);
        return "prueba";
    }

}
