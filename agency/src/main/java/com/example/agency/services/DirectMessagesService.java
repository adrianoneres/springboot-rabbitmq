package com.example.agency.services;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agency.models.DirectMessage;

@Service
public class DirectMessagesService {
  private final RabbitTemplate template;
  private final DirectExchange directMessageExchange;

  @Autowired
  public DirectMessagesService(RabbitTemplate template, DirectExchange directMessDirectExchange) {
    this.template = template;
    this.directMessageExchange = directMessDirectExchange;
  }

  public void execute(DirectMessage directMessage) {
    String routingKey = "rk.directmessages." + directMessage.getDeveloper();

    print(routingKey, directMessage);

    template.convertAndSend(directMessageExchange.getName(), routingKey, directMessage);
  }

  private void print(String routingKey, DirectMessage directMessage) {
    System.out.println(
        "\nSending job opportunity:\n\trouting key: " + routingKey + "\n\tdeveloper: " + directMessage.getDeveloper()
            + "\n\tmessage: " + directMessage.getMessage());

  }
}
