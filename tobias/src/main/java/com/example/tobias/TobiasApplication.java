package com.example.tobias;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tobias.models.Alert;
import com.example.tobias.models.DirectMessage;
import com.example.tobias.models.Opportunity;

@SpringBootApplication
public class TobiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(TobiasApplication.class, args);
	}

	@RabbitListener(queues = "q.directmessages.tobias")
	public void directMessages(DirectMessage directMessage) {
		System.out.println(directMessage);
	}

	@RabbitListener(queues = "q.developers.tobias")
	public void developers(Opportunity opportunity) {
		System.out.println(opportunity);
	}

	@RabbitListener(queues = "q.alerts.tobias")
	public void alerts(Alert alert) {
		System.out.println(alert);
	}
}
