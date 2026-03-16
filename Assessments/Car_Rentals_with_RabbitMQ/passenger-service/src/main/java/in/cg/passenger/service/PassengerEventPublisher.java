package in.cg.passenger.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import in.cg.passenger.config.RabbitMqConfig;
import in.cg.passenger.dto.PassengerCreatedEvent;

@Service
public class PassengerEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public PassengerEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishPassengerCreatedEvent(PassengerCreatedEvent event) {
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE,
                RabbitMqConfig.ROUTING_KEY,
                event
        );

        System.out.println("Passenger Event Published for passengerId: " + event.getPassengerId());
    }
}