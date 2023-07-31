package com.lld.splitwise.services.expense;

import com.lld.splitwise.entities.User;

import java.util.List;

public interface ExpenseService {

  void splitExpense(String paidBy, List<String> users, float amount, String[] splitValue);
}
