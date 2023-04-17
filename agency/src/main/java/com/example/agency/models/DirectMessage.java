package com.example.agency.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DirectMessage {
  private String developer;
  private String message;

  public DirectMessage(String developer, String message) {
    this.developer = developer;
    this.message = message;
  }

  public String getDeveloper() {
    return this.developer;
  }

  public String getMessage() {
    return this.message;
  }

  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
  }
}
