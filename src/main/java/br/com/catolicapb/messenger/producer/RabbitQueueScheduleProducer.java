package br.com.catolicapb.messenger.producer;

import br.com.catolicapb.constants.RabbitConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueScheduleProducer extends RabbitQueueProducer {

    public RabbitQueueScheduleProducer(RabbitTemplate rabbitTemplate) {
        super(rabbitTemplate);
    }

    public void sendMessage(Object object) {
        super.sendMessage(
                RabbitConstants.SCHEDULE_RABBIT_EXCHANGE,
                RabbitConstants.SCHEDULE_RABBIT_QUEUE_NAME,
                object);
    }
}
