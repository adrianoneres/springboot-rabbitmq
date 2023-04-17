package com.example.agency.configurations;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

  @Bean
  public MessageConverter messageConverter() {
    return new Jackson2JsonMessageConverter();
  }

  @Bean
  public RabbitTemplate template(CachingConnectionFactory connectionFactory) {
    RabbitTemplate template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(messageConverter());

    return template;
  }

  @Bean
  public DirectExchange directMessagesExchange() {
    return new DirectExchange("de.directmessages");
  }

  @Bean
  public TopicExchange developersExchange() {
    return new TopicExchange("te.developers");
  }

  @Bean
  public FanoutExchange alertsExchange() {
    return new FanoutExchange("fe.alerts");
  }
}
