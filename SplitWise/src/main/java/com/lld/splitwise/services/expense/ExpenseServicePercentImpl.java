package com.lld.splitwise.services.expense;

import com.lld.splitwise.dao.IDataStorage;
import com.lld.splitwise.dao.IDataStorageLocalImpl;
import com.lld.splitwise.entities.Expense;
import com.lld.splitwise.entities.Split;
import com.lld.splitwise.enums.ExpenseType;
import com.lld.splitwise.exceptions.InvalidSplitException;

import java.util.ArrayList;
import java.util.List;

public class ExpenseServicePercentImpl implements ExpenseService {

  private final IDataStorage db = IDataStorageLocalImpl.getInstance();

  @Override
  public void splitExpense(String paidBy, List<String> users, float amount, String[] splitValue) {
    float sum = 0;
    for (String split : splitValue) {
      sum += Float.parseFloat(split);
    }

    if (sum != 100) {
      throw new InvalidSplitException("Invalid splits");
    }

    List<String> splitIdList = new ArrayList<>();
    int expenseId = db.getAllExpense().size() + 1;
    int startIndex = db.getAllSplit().size() + 1;
    for (int i = startIndex, j = 0; i < startIndex + users.size(); i++, j++) {
      if (paidBy.equals(users.get(j))) {
        continue;
      }
      float splitAmount = getPercentageValue(Float.parseFloat(splitValue[j]), amount);
      Split split = new Split(i, expenseId, users.get(j), splitAmount);
      db.updateBalanceSheet(paidBy, users.get(j), splitAmount);
      db.saveSplit(split);
      splitIdList.add(users.get(j));
    }

    Expense expense = new Expense(expenseId, paidBy, amount, splitIdList, ExpenseType.EQUAL);
    db.saveExpense(expense);
  }

  private float getPercentageValue(float percent, float amount) {
    return (percent/100) * amount;
  }
}
