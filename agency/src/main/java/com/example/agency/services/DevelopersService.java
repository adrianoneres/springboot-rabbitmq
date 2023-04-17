package com.example.agency.services;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agency.models.Opportunity;

@Service
public class DevelopersService {
  private RabbitTemplate template;
  private TopicExchange developersExchange;

  @Autowired
  public DevelopersService(RabbitTemplate template, TopicExchange developersExchange) {
    this.template = template;
    this.developersExchange = developersExchange;
  }

  public void execute(Opportunity opportunity) {
    String routingKey = "rk.developers." + opportunity.getTo() + "." + opportunity.getTechnology();

    print(routingKey, opportunity);

    template.convertAndSend(developersExchange.getName(), routingKey, opportunity);
  }

  private void print(String routingKey, Opportunity opportunity) {
    System.out.println(
        "\nSending direct message:\n\trouting key: " + routingKey + "\n\tto: " + opportunity.getTo()
            + "\n\ttechnology: " + opportunity.getTechnology()
            + "\n\tmessage: " + opportunity.getMessage());

  }
}
