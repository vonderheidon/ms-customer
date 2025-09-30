package br.com.catolicapb.messenger.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public abstract class RabbitQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    protected void sendMessage(String exchange, String queue, Object object) {
        rabbitTemplate.convertAndSend(exchange, queue, object);
    }
}
