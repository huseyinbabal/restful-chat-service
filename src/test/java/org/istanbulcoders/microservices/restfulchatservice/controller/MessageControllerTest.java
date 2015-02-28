package org.istanbulcoders.microservices.restfulchatservice.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.istanbulcoders.microservices.restfulchatservice.ChatApplication;
import org.istanbulcoders.microservices.restfulchatservice.domain.Message;
import org.istanbulcoders.microservices.restfulchatservice.repository.MessageRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChatApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class MessageControllerTest {

    @Autowired
    MessageRepository messageRepository;

    Message message1, message2, message3;

    @Value("${local.server.port}")
    int port;

    @Before
    public void setup() {

        message1 = new Message(
                "John",
                "Mike",
                "Hello Mike, this is John"
        );

        message2 = new Message(
                "Johnny",
                "Betty",
                "Hello Betty, this is Johnny"
        );

        message3 = new Message(
                "Mehmet",
                "Ali",
                "Merhaba Ali, ben Mehmet"
        );

        messageRepository.deleteAll();
        messageRepository.save(message1);
        messageRepository.save(message2);
        messageRepository.save(message3);

        RestAssured.port = port;
    }

    @Test
    public void testList() throws Exception {
        when().
                get("/messages/").
        then().
                statusCode(HttpStatus.OK.value()).
                body("from", Matchers.hasItems("John", "Johnny", "Mehmet")).
                body("to", Matchers.hasItems("Mike", "Betty", "Ali")).
                body("message", Matchers.hasItems("Hello Mike, this is John",
                        "Hello Betty, this is Johnny",
                        "Merhaba Ali, ben Mehmet"));

    }

    @Test
    public void testCreate() throws Exception {

        JsonObject body = new JsonObject();
        body.addProperty("from", "huseyin");
        body.addProperty("to", "veli");
        body.addProperty("message", "selam veli, ben huseyin");

        String messageId = given().contentType(ContentType.JSON).body(body.toString()).
        when().post("/messages/").
            then().statusCode(HttpStatus.OK.value())
                .extract().path("message.id");

        when().get("/messages/" + messageId).
        then().statusCode(HttpStatus.OK.value()).
                body("message.from", Matchers.is("huseyin")).
                body("message.to", Matchers.is("veli")).
                body("message.message", Matchers.is("selam veli, ben huseyin"));

    }
}