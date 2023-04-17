package com.example.tobias.configurations;

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
  // General configuration
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
    return new Queue("q.directmessages.tobias");
  }

  @Bean
  public Binding directMessagesBinding(Queue directMessagesQueue, DirectExchange directMessagesExchange) {
    return BindingBuilder.bind(directMessagesQueue)
        .to(directMessagesExchange)
        .with("rk.directmessages.tobias");
  }

  // Topic Exchange
  @Bean
  public TopicExchange developersExchange() {
    return new TopicExchange("te.developers");
  }

  @Bean
  public Queue developersQueue() {
    return new Queue("q.developers.tobias");
  }

  @Bean
  public Binding developersBinding(Queue developersQueue, TopicExchange developersExchange) {
    return BindingBuilder.bind(developersQueue)
        .to(developersExchange)
        .with("rk.developers.tobias.java");
  }

  // Fanout Exchange
  @Bean
  public FanoutExchange alertsExchange() {
    return new FanoutExchange("fe.alerts");
  }

  @Bean
  public Queue alertsQueue() {
    return new Queue("q.alerts.tobias");
  }

  @Bean
  public Binding alertsBinding(Queue alertsQueue, FanoutExchange alertsExchange) {
    return BindingBuilder.bind(alertsQueue).to(alertsExchange);
  }
}