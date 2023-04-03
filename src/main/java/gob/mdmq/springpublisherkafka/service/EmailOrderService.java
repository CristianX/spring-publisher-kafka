package gob.mdmq.springpublisherkafka.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import gob.mdmq.springpublisherkafka.repository.CorreoRepository;
import gob.mdmq.springpublisherkafka.components.Producer;
import gob.mdmq.springpublisherkafka.model.Correo;
import gob.mdmq.springpublisherkafka.model.CorreoBDD;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailOrderService {

    private Producer producer;
    private final CorreoRepository correoRepository;

    @Autowired
    public EmailOrderService(Producer producer, CorreoRepository correoRepository) {
        this.producer = producer;
        this.correoRepository = correoRepository;
    }

    public String createEmailOrder(Correo emailOrder) throws JsonProcessingException {
        return producer.sendMessage(emailOrder);
    }

    public void save(CorreoBDD correo) {
        correoRepository.save(correo);
    }

    public List<CorreoBDD> findAll() {
        return correoRepository.findAll();
    }

    public Optional<CorreoBDD> findById(String id) {
        return correoRepository.findById(id);
    }

}
