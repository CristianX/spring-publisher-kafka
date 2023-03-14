package gob.mdmq.springpublisherkafka.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gob.mdmq.springpublisherkafka.model.Correo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;

        this.objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    public String sendMessage(Correo email) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(email);
        kafkaTemplate.send(email.getIdSistema(), orderAsMessage);

        log.info("email order producer {}", orderAsMessage);

        return "message sent";
    }

}
