package gob.mdmq.springpublisherkafka.model;

import java.util.List;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Correo {
    String id;
    String idSistema;
    String remitente;
    String destinatarios;
    String asunto;
    String mensaje;
    List<String> adjunto;

}
