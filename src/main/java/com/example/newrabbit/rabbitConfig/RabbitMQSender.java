package com.example.newrabbit.rabbitConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.newrabbit.MenuOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    private static Logger logger = LogManager.getLogger(RabbitMQSender.class.toString());
    public void send(MenuOrder menuOrder) {
        rabbitTemplate.convertAndSend(queue.getName(), menuOrder);
        logger.info("Sending Message to the Queue : " + menuOrder.toString());
    }
}
