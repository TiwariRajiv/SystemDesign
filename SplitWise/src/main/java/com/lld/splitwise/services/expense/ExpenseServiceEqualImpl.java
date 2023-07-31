package com.lld.splitwise.services.expense;

import com.lld.splitwise.dao.IDataStorage;
import com.lld.splitwise.dao.IDataStorageLocalImpl;
import com.lld.splitwise.entities.Expense;
import com.lld.splitwise.entities.Split;
import com.lld.splitwise.enums.ExpenseType;
import com.lld.splitwise.exceptions.InvalidSplitException;

import java.util.ArrayList;
import java.util.List;

public class ExpenseServiceEqualImpl implements ExpenseService {

  private final IDataStorage db = IDataStorageLocalImpl.getInstance();

  @Override
  public void splitExpense(String paidBy, List<String> users, float amount, String[] splitValue) {
    if (amount % users.size() != 0) {
      throw new InvalidSplitException("Amount cannot be split equally");
    }

    List<String> splitIdList = new ArrayList<>();
    int expenseId = db.getAllExpense().size() + 1;
    float splitAmount = amount / users.size();
    int startIndex = db.getAllSplit().size() + 1;
    for (int i = startIndex, j = 0; i < startIndex + users.size(); i++, j++) {
      if (paidBy.equals(users.get(j))) {
        continue;
      }
      Split split = new Split(i, expenseId, users.get(j), splitAmount);
      db.updateBalanceSheet(paidBy, users.get(j), splitAmount);
      db.saveSplit(split);
      splitIdList.add(users.get(j));
    }

    Expense expense = new Expense(expenseId, paidBy, amount, splitIdList, ExpenseType.EQUAL);
    db.saveExpense(expense);
  }
}
