package org.istanbulcoders.microservices.restfulchatservice.controller;


import org.istanbulcoders.microservices.restfulchatservice.RabbitMQ;
import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.istanbulcoders.microservices.restfulchatservice.repository.MessageRepository;
import org.istanbulcoders.microservices.restfulchatservice.request.MessageRequest;
import org.istanbulcoders.microservices.restfulchatservice.resource.MessageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private RabbitMQ rabbitMQ;

    @RequestMapping(value = "/{to}", method = RequestMethod.GET)
    HttpEntity<List<MessageResource>> list(@PathVariable("to") String to) {
        List messages;
        if (to != null) {
            messages = messageRepository.findAllByTo(to);
        } else {
            messages = messageRepository.findAll();
        }

        return new ResponseEntity<List<MessageResource>>(messages, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    HttpEntity<MessageResource> create(@RequestBody MessageRequest messageRequest) {
        Message savedMessage = messageRepository.save(new Message(
                messageRequest.getFrom(),
                messageRequest.getTo(),
                messageRequest.getMessage(),
                new Date()
            )
        );
        rabbitMQ.sendMessage(savedMessage.toString());
        return new ResponseEntity<>(new MessageResource(savedMessage), HttpStatus.OK);
    }
}