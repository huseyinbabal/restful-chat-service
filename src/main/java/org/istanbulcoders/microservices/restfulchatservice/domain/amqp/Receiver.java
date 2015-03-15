package org.istanbulcoders.microservices.restfulchatservice.domain.amqp;

import java.util.concurrent.CountDownLatch;

/**
 * Created by huseyin on 3/15/2015.
 */
public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
