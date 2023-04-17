package com.example.tieta.models;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DirectMessage {
  private String developer;
  private String message;

  public DirectMessage() {
  }

  public DirectMessage(String developer, String message) {
    this.developer = developer;
    this.message = message;
  }

  public String getDeveloper() {
    return this.developer;
  }

  public void setDeveloper(String developer) {
    this.developer = developer;
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
