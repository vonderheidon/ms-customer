package br.com.catolicapb.config;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;

@RequiredArgsConstructor
public class RabbitQueueConfig {

    private final RabbitAdmin rabbitAdmin;
    private final String queue;
    private final String exchange;

    public void createQueue() {
        rabbitAdmin.declareQueue(QueueBuilder.durable(queue).build());
    }

    public void createExchange() {
        rabbitAdmin.declareExchange(ExchangeBuilder.directExchange(exchange).build());
    }

    public void createBindingQueue() {
        rabbitAdmin
                .declareBinding(new Binding(queue, Binding.DestinationType.QUEUE, exchange, queue, null));
    }
}
