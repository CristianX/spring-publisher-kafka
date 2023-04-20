package gob.mdmq.springpublisherkafka.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import gob.mdmq.springpublisherkafka.model.CorreoBDD;

@Repository
public interface CorreoRepository extends MongoRepository<CorreoBDD, String> {

    
}
