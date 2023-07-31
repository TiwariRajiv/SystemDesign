package com.lld.splitwise.dao;

import com.lld.splitwise.entities.Expense;
import com.lld.splitwise.entities.Split;
import com.lld.splitwise.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IDataStorageLocalImpl implements IDataStorage {

  private static final Map<String, User> userMap = new ConcurrentHashMap<>();
  private static final Map<Integer, Split> splitMap = new ConcurrentHashMap<>();
  private static final Map<Integer, Expense> expenseMap = new ConcurrentHashMap<>();
  private static final Map<String, Float> balanceSheetMap = new ConcurrentHashMap<>();

  private static final class InstanceHolder {
    static final IDataStorageLocalImpl instance = new IDataStorageLocalImpl();
  }

  public static IDataStorage getInstance() {
    return InstanceHolder.instance;
  }

  @Override
  public void saveUser(User user) {
    userMap.put(user.getUserId(), user);
  }

  @Override
  public void saveSplit(Split split) {
    splitMap.put(split.getSplitId(), split);
  }

  @Override
  public void saveExpense(Expense expense) {
    expenseMap.put(expense.getExpenseId(), expense);
  }

  @Override
  public User getUser(String userId) {
    return userMap.get(userId);
  }

  @Override
  public Split getSplit(int splitId) {
    return splitMap.get(splitId);
  }

  @Override
  public Expense getExpense(int expenseId) {
    return expenseMap.get(expenseId);
  }

  @Override
  public List<User> getAllUsers() {
    return new ArrayList<>(userMap.values());
  }

  @Override
  public List<Split> getAllSplit() {
    return new ArrayList<>(splitMap.values());
  }

  @Override
  public List<Expense> getAllExpense() {
    return new ArrayList<>(expenseMap.values());
  }

  @Override
  public void updateBalanceSheet(String paidBy, String paidFor, float splitAmount) {
    String key1 = paidBy + "-" + paidFor;
    String key2 = paidFor + "-" + paidBy;
    if (balanceSheetMap.containsKey(key1)) {
      balanceSheetMap.put(key1, balanceSheetMap.get(key1) + splitAmount);
    } else if (balanceSheetMap.containsKey(key2)) {
      float updatedAmount = balanceSheetMap.get(key2) - splitAmount;
      if (updatedAmount < 0) {
        balanceSheetMap.remove(key2);
        balanceSheetMap.put(key1, Math.abs(updatedAmount));
      } else {
        balanceSheetMap.put(key2, updatedAmount);
      }
    } else {
      balanceSheetMap.put(key1, splitAmount);
    }
  }

  @Override
  public Map<String, Float> getBalanceSheet() {
    return balanceSheetMap;
  }
}
