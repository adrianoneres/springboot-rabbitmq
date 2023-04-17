package com.example.agency.services;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.agency.models.Alert;

@Service
public class AlertsService {
  private RabbitTemplate template;
  private FanoutExchange alertsExchange;

  @Autowired
  public AlertsService(RabbitTemplate template, FanoutExchange alertsExchange) {
    this.template = template;
    this.alertsExchange = alertsExchange;
  }

  public void execute(Alert alert) {
    print(alert);

    template.convertAndSend(alertsExchange.getName(), null, alert);
  }

  private void print(Alert alert) {
    System.out.println(
        "\nSending alert:\n\tmessage: " + alert.getMessage());

  }
}
