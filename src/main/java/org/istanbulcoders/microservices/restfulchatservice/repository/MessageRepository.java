package org.istanbulcoders.microservices.restfulchatservice.repository;


import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    List<Message> findAllByTo(String to);
}
