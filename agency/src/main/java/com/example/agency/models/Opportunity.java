package com.example.agency.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Opportunity {
  private String to;
  private String technology;
  private String message;

  public Opportunity(String to, String technology, String message) {
    this.to = to;
    this.technology = technology;
    this.message = message;
  }

  public String getTo() {
    return this.to;
  }

  public String getTechnology() {
    return this.technology;
  }

  public String getMessage() {
    return this.message;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
