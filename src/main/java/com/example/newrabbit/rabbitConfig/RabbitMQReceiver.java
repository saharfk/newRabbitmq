package com.example.newrabbit.rabbitConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RabbitListener(queues = "log-queue", id = "listener")
public class RabbitMQReceiver {
    private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());
    @Autowired
    RabbitAutoConfiguration rabbitAutoConfiguration;
    @Autowired
    RestTemplate restTemplate;

    @RabbitHandler
    public void receiver(String log) {
        logger.debug("message receive from rabbit");
        System.out.println("wtf");
        String url = rabbitAutoConfiguration.getRabbitUrl();
        System.out.println(log);
        System.out.println(url);
        HttpEntity<String> request = new HttpEntity<>(log);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
        System.out.println("response is : " + response);
        System.out.println("Message received from queue : " + log);

    }
}
