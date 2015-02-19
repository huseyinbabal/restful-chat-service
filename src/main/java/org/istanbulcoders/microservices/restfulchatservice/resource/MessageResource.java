package org.istanbulcoders.microservices.restfulchatservice.resource;

import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.springframework.hateoas.ResourceSupport;

public class MessageResource extends ResourceSupport {

    private final Message message;

    public MessageResource(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return this.message;
    }

}
