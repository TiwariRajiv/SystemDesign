package com.lld.splitwise.services.expense.factory;

import com.lld.splitwise.enums.ExpenseType;
import com.lld.splitwise.services.expense.ExpenseService;
import com.lld.splitwise.services.expense.ExpenseServiceEqualImpl;
import com.lld.splitwise.services.expense.ExpenseServiceExactImpl;
import com.lld.splitwise.services.expense.ExpenseServicePercentImpl;

import java.util.HashMap;
import java.util.Map;

public class ExpenseServiceFactory {

  private static final Map<String, ExpenseService> expenseServiceMap = new HashMap<>();

  static {
    expenseServiceMap.put(ExpenseType.EQUAL.getExpenseType(), new ExpenseServiceEqualImpl());
    expenseServiceMap.put(ExpenseType.EXACT.getExpenseType(), new ExpenseServiceExactImpl());
    expenseServiceMap.put(ExpenseType.PERCENT.getExpenseType(), new ExpenseServicePercentImpl());
  }

  public static ExpenseService getExpenseService(ExpenseType expenseType) {
    return expenseServiceMap.get(expenseType.getExpenseType());
  }
}
