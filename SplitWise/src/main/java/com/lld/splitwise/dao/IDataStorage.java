package com.lld.splitwise.dao;

import com.lld.splitwise.entities.Expense;
import com.lld.splitwise.entities.Split;
import com.lld.splitwise.entities.User;

import java.util.List;
import java.util.Map;

public interface IDataStorage {

  void saveUser(User user);
  void saveSplit(Split split);
  void saveExpense(Expense expense);
  User getUser(String userId);
  Split getSplit(int splitId);
  Expense getExpense(int expenseId);
  List<User> getAllUsers();
  List<Split> getAllSplit();
  List<Expense> getAllExpense();
  void updateBalanceSheet(String paidBy, String paidFor, float splitAmount);
  Map<String, Float> getBalanceSheet();
}
