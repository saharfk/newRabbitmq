package com.example.newrabbit.rabbitConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.newrabbit.MenuOrder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
@RabbitListener(queues = "log-queue", id = "listener")
public class RabbitMQReceiver {
    private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());
    @RabbitHandler
    public void receiver(String log) {
        logger.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : " + log);
    }
}
