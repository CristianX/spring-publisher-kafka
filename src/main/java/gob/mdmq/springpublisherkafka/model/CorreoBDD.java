package gob.mdmq.springpublisherkafka.model;

import java.util.List;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class CorreoBDD {

    String idSistema;
    String remitente;
    String destinatarios;
    String asunto;
    String mensaje;
    List<String> adjunto;
    Boolean enviado;
}
