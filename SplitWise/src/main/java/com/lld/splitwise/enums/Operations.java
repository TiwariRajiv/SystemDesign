package com.lld.splitwise.enums;

public enum Operations {

  SHOW("SHOW"),
  EXPENSE("EXPENSE"),
  QUIT("QUIT");

  private final String operation;

  Operations(String operation) {
    this.operation = operation;
  }

  public String getOperation() {
    return operation;
  }
}
