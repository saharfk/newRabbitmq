package com.example.newrabbit.controllers;

import com.example.newrabbit.rabbitConfig.RabbitMQSender;
import com.example.newrabbit.MenuOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/rabbit")
public class RabbitMQDemoController {
    @Autowired
    RabbitMQSender rabbitMQSender;
    @PostMapping(value = "/report")
    public String producer(@RequestBody String log) {
        rabbitMQSender.send(log);
        return "Message sent to the RabbitMQ Queue Successfully";
    }
}