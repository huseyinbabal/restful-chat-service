package org.istanbulcoders.microservices.restfulchatservice.controller;


import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.istanbulcoders.microservices.restfulchatservice.repository.MessageRepository;
import org.istanbulcoders.microservices.restfulchatservice.resource.MessageResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    HttpEntity<List<MessageResource>> list() {
        List messages = messageRepository.findAll();
        return new ResponseEntity<List<MessageResource>>(messages, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    HttpEntity<MessageResource> create(HttpServletRequest request,
                                       @RequestParam("from") String from,
                                       @RequestParam("to") String to,
                                       @RequestParam("message") String message
                                       ) {
        Message savedMessage = messageRepository.save(new Message(from, to, message));
        return new ResponseEntity<>(new MessageResource(savedMessage), HttpStatus.OK);
    }
}