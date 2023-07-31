package com.lld.splitwise.enums;

public enum ExpenseType {

  EQUAL("EQUAL"),
  EXACT("EXACT"),
  PERCENT("PERCENT");

  private final String type;

  ExpenseType(final String type) {
    this.type = type;
  }

  public String getExpenseType() {
    return type;
  }
}
