package com.example.tieta;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tieta.models.Alert;
import com.example.tieta.models.DirectMessage;
import com.example.tieta.models.Opportunity;

@SpringBootApplication
public class TietaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TietaApplication.class, args);
	}

	@RabbitListener(queues = "q.directmessages.tieta")
	public void directMessages(DirectMessage directMessage) {
		System.out.println(directMessage);
	}

	@RabbitListener(queues = "q.developers.tieta")
	public void developers(Opportunity opportunity) {
		System.out.println(opportunity);
	}

	@RabbitListener(queues = "q.alerts.tieta")
	public void alerts(Alert alert) {
		System.out.println(alert);
	}
}
