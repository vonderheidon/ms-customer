package br.com.catolicapb.config;

import br.com.catolicapb.constants.RabbitConstants;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleRabbitConfig extends RabbitQueueConfig {

    public ScheduleRabbitConfig(RabbitAdmin rabbitAdmin) {
        super(rabbitAdmin, RabbitConstants.SCHEDULE_RABBIT_QUEUE_NAME, RabbitConstants.SCHEDULE_RABBIT_EXCHANGE);
    }

    @PostConstruct
    public void createRabbitConfiguration() {
        createQueue();
        createExchange();
        createBindingQueue();
    }
}
