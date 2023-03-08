package gob.mdmq.springpublisherkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import gob.mdmq.springpublisherkafka.model.Correo;
import gob.mdmq.springpublisherkafka.service.EmailOrderService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/send-email")
public class EmailOrderController {

    private final EmailOrderService foodOrderService;

    @Autowired
    public EmailOrderController(EmailOrderService foodOrderService) {
        this.foodOrderService = foodOrderService;
    }

    @PostMapping
    public String createFoodOrder(@RequestBody Correo foodOrder) throws JsonProcessingException {
        log.info("Create email recived");
        return foodOrderService.createFoodOrder(foodOrder);
    }

}
