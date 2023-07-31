package com.lld.splitwise.entities;

public class Split {

  private int splitId;
  private int transactionId;
  private String userId;
  private float amount;

  public Split() {
  }

  public Split(int splitId, int transactionId, String userId, float amount) {
    this.splitId = splitId;
    this.transactionId = transactionId;
    this.userId = userId;
    this.amount = amount;
  }

  public int getSplitId() {
    return splitId;
  }

  public void setSplitId(int splitId) {
    this.splitId = splitId;
  }

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Split{" +
            "splitId=" + splitId +
            ", expenseId=" + transactionId +
            ", user=" + userId +
            ", amount=" + amount +
            '}';
  }
}
