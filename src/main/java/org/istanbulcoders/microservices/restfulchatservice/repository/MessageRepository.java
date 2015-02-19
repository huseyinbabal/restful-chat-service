package org.istanbulcoders.microservices.restfulchatservice.repository;


import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {}
