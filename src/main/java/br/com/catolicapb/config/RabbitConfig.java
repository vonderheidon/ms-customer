package br.com.catolicapb.config;

import br.com.catolicapb.constants.CustomerConstants;
import br.com.catolicapb.constants.RabbitConstants;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.port}")
    private int port;

    @Bean
    @Primary
    public RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(Jackson2JsonMessageConverter converter) {
        var rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(converter);
        return rabbitTemplate;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        var connection = new CachingConnectionFactory();
        connection.setAddresses(host);
        connection.setUsername(username);
        connection.setPassword(password);
        connection.setPort(port);
        return connection;
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(RabbitConstants.SCHEDULE_RABBIT_CONNECTION_FACTORY)
    public SimpleRabbitListenerContainerFactory containerFactory() {
        var simpleContainerFactory = new SimpleRabbitListenerContainerFactory();
        simpleContainerFactory.setConnectionFactory(connectionFactory());
        return simpleContainerFactory;
    }
}
