package com.furkansoyleyici.easynoteapi.rabbitmq;

import com.furkansoyleyici.easynoteapi.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Mesaj alındı: " + message);
    }
}
