package gob.mdmq.springpublisherkafka.model;

import java.util.List;

import lombok.Data;
import lombok.Value;

@Data
@Value
public class Correo {

    String idSistema;
    String remitente;
    List<String> destinatarios;
    String asunto;
    String mensaje;
    List<String> copia;
    List<String> copiaOculta;
    List<String> adjunto;
}
