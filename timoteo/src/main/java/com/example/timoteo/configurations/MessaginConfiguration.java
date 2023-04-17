package com.example.timoteo.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessaginConfiguration {
  // General confguration
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

  // Direct Exchange
  @Bean
  public DirectExchange directMessagesExchange() {
    return new DirectExchange("de.directmessages");
  }

  @Bean
  public Queue directMessagesQueue() {
    return new Queue("q.directmessages.timoteo");
  }

  @Bean
  public Binding directMessagesBinding(Queue directMessagesQueue, DirectExchange directMessagesExchange) {
    return BindingBuilder.bind(directMessagesQueue)
        .to(directMessagesExchange)
        .with("rk.directmessages.timoteo");
  }

  // Topic Exchange
  @Bean
  public TopicExchange developersExchange() {
    return new TopicExchange("te.developers");
  }

  @Bean
  public Queue developersQueue() {
    return new Queue("q.developers.timoteo");
  }

  @Bean
  public Binding developersBinding(Queue developersQueue, TopicExchange developersExchange) {
    return BindingBuilder.bind(developersQueue)
        .to(developersExchange)
        .with("rk.developers.timoteo.javascript");
  }

  // Fanout Exchange
  @Bean
  public FanoutExchange alertsExchange() {
    return new FanoutExchange("fe.alerts");
  }

  @Bean
  public Queue alertsQueue() {
    return new Queue("q.alerts.timoteo");
  }

  @Bean
  public Binding alertsBinding(Queue alertsQueue, FanoutExchange alertsExchange) {
    return BindingBuilder.bind(alertsQueue).to(alertsExchange);
  }
}