package com.example.tiao;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.tiao.models.Alert;
import com.example.tiao.models.DirectMessage;
import com.example.tiao.models.Opportunity;

@SpringBootApplication
public class TiaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiaoApplication.class, args);
	}

	@RabbitListener(queues = "q.directmessages.tiao")
	public void directMessages(DirectMessage directMessage) {
		System.out.println(directMessage);
	}

	@RabbitListener(queues = "q.developers.tiao")
	public void developers(Opportunity opportunity) {
		System.out.println(opportunity);
	}

	@RabbitListener(queues = "q.alerts.tiao")
	public void alerts(Alert alert) {
		System.out.println(alert);
	}
}
