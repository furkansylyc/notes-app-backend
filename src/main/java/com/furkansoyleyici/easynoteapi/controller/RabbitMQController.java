package com.furkansoyleyici.easynoteapi.controller;

import com.furkansoyleyici.easynoteapi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class RabbitMQController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

   @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
    rabbitTemplate.convertAndSend("testQueue", message);
    return "Mesaj gönderildi: " + message;
}

}
