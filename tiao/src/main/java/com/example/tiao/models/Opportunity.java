package com.example.tiao.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Opportunity {
  private String to;
  private String technology;
  private String message;

  public Opportunity() {
  }

  public Opportunity(String to, String technology, String message) {
    this.to = to;
    this.technology = technology;
    this.message = message;
  }

  public String getTo() {
    return this.to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getTechnology() {
    return this.technology;
  }

  public void setTechnology(String technology) {
    this.technology = technology;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
