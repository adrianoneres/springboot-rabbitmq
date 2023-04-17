package com.example.timoteo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.timoteo.models.Alert;
import com.example.timoteo.models.DirectMessage;
import com.example.timoteo.models.Opportunity;

@SpringBootApplication
public class TimoteoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimoteoApplication.class, args);
	}

	@RabbitListener(queues = "q.directmessages.timoteo")
	public void directMessages(DirectMessage directMessage) {
		System.out.println(directMessage);
	}

	@RabbitListener(queues = "q.developers.timoteo")
	public void developers(Opportunity opportunity) {
		System.out.println(opportunity);
	}

	@RabbitListener(queues = "q.alerts.timoteo")
	public void alerts(Alert alert) {
		System.out.println(alert);
	}
}
