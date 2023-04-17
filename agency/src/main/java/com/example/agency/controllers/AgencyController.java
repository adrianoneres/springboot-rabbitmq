package com.example.agency.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.agency.models.Alert;
import com.example.agency.models.DirectMessage;
import com.example.agency.models.Opportunity;
import com.example.agency.services.AlertsService;
import com.example.agency.services.DevelopersService;
import com.example.agency.services.DirectMessagesService;

@RestController
public class AgencyController {
  private final DirectMessagesService directMessagesService;
  private final DevelopersService developersService;
  private final AlertsService alertsService;

  @Autowired
  public AgencyController(DirectMessagesService directMessagesService, DevelopersService developersService,
      AlertsService alertsService) {
    this.directMessagesService = directMessagesService;
    this.developersService = developersService;
    this.alertsService = alertsService;
  }

  @PostMapping("/direct-messages")
  public ResponseEntity<String> directMessages(@RequestBody DirectMessage directMessage) {
    directMessagesService.execute(directMessage);

    return ResponseEntity.ok().body("Success");
  }

  @PostMapping("/developers")
  public ResponseEntity<String> developers(@RequestBody Opportunity opportunity) {
    developersService.execute(opportunity);

    return ResponseEntity.ok().body("Success");
  }

  @PostMapping("/alerts")
  public ResponseEntity<String> alerts(@RequestBody Alert alert) {
    alertsService.execute(alert);

    return ResponseEntity.ok().body("Success");
  }
}
