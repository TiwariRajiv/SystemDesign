package com.lld.splitwise.entities;

import com.lld.splitwise.enums.ExpenseType;

import java.util.List;

public class Expense {

  private int expenseId;
  private String paidBy;
  private float amount;
  private List<String> paidFor;
  private ExpenseType expenseType;

  public Expense() {
  }

  public Expense(int expenseId, String paidBy, float amount, List<String> paidFor, ExpenseType expenseType) {
    this.expenseId = expenseId;
    this.paidBy = paidBy;
    this.amount = amount;
    this.paidFor = paidFor;
    this.expenseType = expenseType;
  }

  public int getExpenseId() {
    return expenseId;
  }

  public void setExpenseId(int expenseId) {
    this.expenseId = expenseId;
  }

  public String getPaidBy() {
    return paidBy;
  }

  public void setPaidBy(String paidBy) {
    this.paidBy = paidBy;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public List<String> getPaidFor() {
    return paidFor;
  }

  public void setPaidFor(List<String> paidFor) {
    this.paidFor = paidFor;
  }

  public ExpenseType getExpenseType() {
    return expenseType;
  }

  public void setExpenseType(ExpenseType expenseType) {
    this.expenseType = expenseType;
  }

  @Override
  public String toString() {
    return "Expense{" +
            "transactionId=" + expenseId +
            ", paidBy=" + paidBy +
            ", amount=" + amount +
            ", paidFor=" + paidFor +
            ", expenseType=" + expenseType +
            '}';
  }
}
