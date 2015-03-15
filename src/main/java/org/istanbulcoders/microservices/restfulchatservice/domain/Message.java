package org.istanbulcoders.microservices.restfulchatservice.domain;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Message {
    @Id
    private String id;
    private String from;
    private String to;
    private String message;
    private Date date;

    public Message() {
    }
    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.date = new Date();
    }

    public Message(String from, String to, String message, Date date) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
