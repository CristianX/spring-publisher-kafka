package gob.mdmq.springpublisherkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import gob.mdmq.springpublisherkafka.model.Correo;
import gob.mdmq.springpublisherkafka.producer.Producer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailOrderService {

    private Producer producer;

    @Autowired
    public EmailOrderService(Producer producer) {
        this.producer = producer;
    }

    public String createFoodOrder(Correo foodOrder) throws JsonProcessingException {
        return producer.sendMessage(foodOrder);
    }

}
